package flight;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FlightRepository extends CrudRepository<Flight, Long> {
}
