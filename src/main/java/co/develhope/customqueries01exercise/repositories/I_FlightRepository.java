package co.develhope.customqueries01exercise.repositories;

import co.develhope.customqueries01exercise.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_FlightRepository extends JpaRepository<Flight, Integer> {
}
