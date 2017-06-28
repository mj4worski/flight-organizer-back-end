package flight;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightFacade {

    private FindService findService;

    public FlightFacade(FindService findService) {
        this.findService = findService;
    }

    public List<FlightDto> findFlights(String from, String to) {
        return findService.findExistingFlights(from, to);
    }
}
