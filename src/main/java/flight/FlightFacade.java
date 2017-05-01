package flight;

import org.springframework.stereotype.Component;
import rest.dto.FlightDTO;

import java.util.List;

@Component
public class FlightFacade {

    private FindService findService;

    public FlightFacade(FindService findService) {
        this.findService = findService;
    }

    public List<FlightDTO> findFlights(String from, String to) {
        return findService.findExistingFlights(from, to);
    }
}
