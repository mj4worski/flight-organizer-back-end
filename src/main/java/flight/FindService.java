package flight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
class FindService {
    List<Flight> find(String from, String to) {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Warsow", "Cracow"));
        List<Flight> matchedFlights = flights.stream()
                .filter(flight -> flight.equals(new Flight(from, to)))
                .collect(Collectors.toList());
        return matchedFlights;
    }
}
