package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id){
        return flightRepository.findById(id).get();
    }

    @Transactional
    public Flight bookFlight(BookingDTO bookingDTO){
        //get the specific flight
        Flight flight = flightRepository.findById(bookingDTO.getFlightId()).get();
        //get the passenger from the DB and add them to flight
        flight.addPassenger(passengerRepository.findById(bookingDTO.getPassengerId()).get());
        //patch the flight in the DB
        flightRepository.save(flight);
        return flight;
    }

    public String cancelFlight(Long id){
        String msg = String.format("Cancelled flight to %s", flightRepository.findById(id).get().getDestination());
        flightRepository.delete(flightRepository.getReferenceById(id));
        return msg;
    }
}
