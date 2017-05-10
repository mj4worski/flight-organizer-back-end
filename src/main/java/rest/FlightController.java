package rest;

import flight.FlightFacade;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.dto.FlightDTO;

import java.util.List;

@RestController()
@RequestMapping("/public")
class FlightController {

    final private FlightFacade flightFacade;

    public FlightController(FlightFacade flightFacade) {
        this.flightFacade = flightFacade;
    }

    @GetMapping(path = "/findFlights")
    List<FlightDTO> findFlights(@RequestParam("from") String from, @RequestParam("to") String to){
        Assert.notNull(to, "To can't be null");
        Assert.notNull(from, "From can't be null");
        return flightFacade.findFlights(from, to);
    }

}
