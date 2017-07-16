package flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface FlightRepository extends CrudRepository<Flight, Long> {

    List<Flight> findByDepartureFromAndArrivalTo(String departureFrom, String arrivalTo);
}
