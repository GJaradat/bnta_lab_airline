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
        Flight flightGLA = new Flight("Glasgow", 5, "29/02/2024", "17:15");
        flightRepository.save(flightGLA);

        Flight flightSOF = new Flight("Sofia", 10, "01/03/2024", "10:15");
        flightRepository.save(flightSOF);

        Flight flightSTN = new Flight("Stansted", 5, "28/02/2024", "19:10");
        flightRepository.save(flightSTN);

        Flight flightMIA = new Flight("Malta", 3, "29/02/2024", "07:55");
        flightRepository.save(flightMIA);

        Flight flightHND = new Flight("Tokyo", 1, "04/03/2024", "10:04");
        flightRepository.save(flightHND);

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
//        flightService.bookFlight(new BookingDTO(4L,1L));
//        flightService.bookFlight(1L, 2L);
//        flightService.bookFlight(1L, 3L);
//        flightService.bookFlight(2L, 4L);
//        flightService.bookFlight(3L, 5L);
//        flightService.bookFlight(4L, 6L);
//
//        flightService.bookFlight(5L, 1L);
//        flightService.bookFlight(5L, 2L);
//        flightService.bookFlight(5L, 3L);
//        flightService.bookFlight(5L, 4L);
//        flightService.bookFlight(5L, 5L);
//        flightService.bookFlight(5L, 6L);




    }
}
