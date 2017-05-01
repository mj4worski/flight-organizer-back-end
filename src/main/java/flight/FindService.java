package flight;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import rest.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
class FindService {

    final private FlightRepository flightRepository;

    final private DozerBeanMapper dozerBeanMapper;

    public FindService(FlightRepository flightRepository, DozerBeanMapper dozerBeanMapper) {
        this.flightRepository = flightRepository;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    List<FlightDTO> find(String from, String to) {
        Iterable<Flight> flights = flightRepository.findAll();

        List<Flight> matchedFlights = StreamSupport.stream(flights.spliterator(), false)
                .filter(flight -> flight.equals(new Flight(from, to)))
                .collect(Collectors.toList());

        List<FlightDTO> mappedFlightDTO = matchedFlights
                .stream()
                .map(flight -> dozerBeanMapper.map(flight, FlightDTO.class))
                .collect(Collectors.toList());

        return mappedFlightDTO;
    }

    void saveFlight(Flight flight){
        flightRepository.save(flight);
    }
}
