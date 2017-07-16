package flight;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class FindService {

    final private FlightRepository flightRepository;

    public FindService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    List<FlightDto> findExistingFlights(String departureFrom, String arrivalTo) {
        List<Flight> matchedFlights = flightRepository.findByDepartureFromAndArrivalTo(departureFrom, arrivalTo);
        return matchedFlights
                .stream()
                .map(flight -> flight.toDto())
                .collect(Collectors.toList());
    }
}
