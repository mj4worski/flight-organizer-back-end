package rest;

import flight.FlightFacade;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import flight.FlightDto;

import java.util.List;

@RestController()
class FlightController {

    final private FlightFacade flightFacade;

    public FlightController(FlightFacade flightFacade) {
        this.flightFacade = flightFacade;
    }

    @GetMapping(path = "/findFlights")
    List<FlightDto> findFlights(@RequestParam("departureFrom") String departureFrom,
                                @RequestParam("arrivalTo") String arrivalTo) {
        Assert.notNull(arrivalTo, "arrivalTo can't be null");
        Assert.notNull(departureFrom, "departureFrom can't be null");
        return flightFacade.findFlights(departureFrom, arrivalTo);
    }

}
