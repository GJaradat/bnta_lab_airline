package com.example.airline_api.components;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;

    public DataLoader() {
    }

    @Override
    public void run (ApplicationArguments args) throws Exception{

        //Generate flights
        Flight flightGLA = new Flight("Glasgow", 5, LocalDate.of(2024, 2, 29), LocalTime.of(17,15));
        flightRepository.save(flightGLA);

        Flight flightSOF = new Flight("Sofia", 10, LocalDate.of(2024, 3, 1), LocalTime.of(18,25));
        flightRepository.save(flightSOF);

        Flight flightSTN = new Flight("Stansted", 5, LocalDate.of(2024, 2, 28), LocalTime.of(10,15));
        flightRepository.save(flightSTN);

        Flight flightMIA = new Flight("Malta", 3, LocalDate.of(2024, 2, 24), LocalTime.of(7,45));
        flightRepository.save(flightMIA);

        Flight flightHND = new Flight("Tokyo", 10, LocalDate.of(2024, 2, 29), LocalTime.of(19,22));
        flightRepository.save(flightHND);

        Flight flightGLA2 = new Flight("Glasgow", 2, LocalDate.of(2024, 2, 22), LocalTime.of(17,15));
        flightRepository.save(flightGLA2);

        //Generate passengers
        Passenger passenger1 = new Passenger("Zsolt", "vismajor@gmail.com");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("Anna", "anna@gmail.com");
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Colin", "colin@gmail.com");
        passengerRepository.save(passenger3);

        Passenger passenger4 = new Passenger("Thibyaa", "Thibyaa@gmail.com");
        passengerRepository.save(passenger4);

        Passenger passenger5 = new Passenger("Richard", "Richard@gmail.com");
        passengerRepository.save(passenger5);

        Passenger passenger6 = new Passenger("Phil", "ThePhillinator@gmail.com");
        passengerRepository.save(passenger6);

        //Book flights
        flightService.bookFlight(new BookingDTO(4L, 1L));
        flightService.bookFlight(new BookingDTO(1L, 2L));
        flightService.bookFlight(new BookingDTO(1L, 3L));
        flightService.bookFlight(new BookingDTO(2L, 4L));
        flightService.bookFlight(new BookingDTO(3L, 5L));
        flightService.bookFlight(new BookingDTO(4L, 6L));

        flightService.bookFlight(new BookingDTO(5L, 1L));
        flightService.bookFlight(new BookingDTO(5L, 2L));
        flightService.bookFlight(new BookingDTO(5L, 3L));
        flightService.bookFlight(new BookingDTO(5L, 4L));
        flightService.bookFlight(new BookingDTO(5L, 5L));
        flightService.bookFlight(new BookingDTO(5L, 6L));

        //fill flight to Glasgow
        flightService.bookFlight(new BookingDTO(6L, 1L));
        flightService.bookFlight(new BookingDTO(6L, 3L));


    }
}
