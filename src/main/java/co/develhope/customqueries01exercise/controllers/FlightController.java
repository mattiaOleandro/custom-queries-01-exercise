package co.develhope.customqueries01exercise.controllers;

import co.develhope.customqueries01exercise.entities.Flight;
import co.develhope.customqueries01exercise.repositories.I_FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static co.develhope.customqueries01exercise.entities.Status.ON_TIME;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private I_FlightRepository i_flightRepository;

    public String generateRandomValueForFlight() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    @GetMapping("/loadFlight")
    public List<Flight> randomFlight() {
        List<Flight> randomFlight = new ArrayList<>();
        for (Integer i = 0; i <= 50; i++) {
            randomFlight.add(new Flight(i, generateRandomValueForFlight(), generateRandomValueForFlight(), generateRandomValueForFlight(),ON_TIME));
        }
        i_flightRepository.saveAllAndFlush(randomFlight);
        return randomFlight;
    }

    @GetMapping
    public List<Flight> getAllFlight(){
        return i_flightRepository.findAll();
    }
}
