package flight;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
class FindService {

    final private FlightRepository flightRepository;

    public FindService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    List<FlightDto> findExistingFlights(String from, String to) {
        Iterable<Flight> flights = flightRepository.findAll();

        //TODO : Move to database WHERE clausule
        List<Flight> matchedFlights = StreamSupport.stream(flights.spliterator(), false)
                .filter(flight -> flight.equals(new Flight(from, to)))
                .collect(Collectors.toList());

        return matchedFlights
                .stream()
                .map(flight -> flight.toDto())
                .collect(Collectors.toList());
    }

    void saveFlight(Flight flight){
        flightRepository.save(flight);
    }
}
