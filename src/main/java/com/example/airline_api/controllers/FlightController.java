package com.example.airline_api.controllers;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlightsAndFilters(
            @RequestParam(required = false, name = "destination") String destination
    ){
        if(destination != null){
            List<Flight> flights = flightService.getAllFlightsFilter(destination);
            if(flights.isEmpty()){
                // return 404 if no flights to that destination
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            //return filtered flights by given destination
            return new ResponseEntity<>(flightService.getAllFlightsFilter(destination), HttpStatus.OK);
        }
        //return all flights
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        if (!flightService.checkIfFlightExists(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flightService.getFlightById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody BookingDTO bookingDTO){
        Flight flight = flightService.bookFlight(bookingDTO);
        if (flight == null){
            //flight is full already
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> cancelFlight(@PathVariable Long id){
        if (!flightService.checkIfFlightExists(id)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flightService.cancelFlight(id), HttpStatus.OK);
    }

}
