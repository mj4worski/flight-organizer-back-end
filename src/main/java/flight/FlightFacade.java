package flight;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightFacade {

    final private FindService findService;

    public FlightFacade(FindService findService) {
        this.findService = findService;
    }

    public List<FlightDto> findFlights(String departureFrom, String arrivalTo) {
        return findService.findExistingFlights(departureFrom, arrivalTo);
    }
}
