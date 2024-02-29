package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
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
//        Passenger passenger1 = new Passenger("Zsolt", "vismajor@gmail.com");
        

    }
}
