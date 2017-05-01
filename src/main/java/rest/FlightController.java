package rest;

import flight.FlightFacade;
import org.springframework.stereotype.Controller;

@Controller
class FlightController {

    final private FlightFacade flightFacade;

    public FlightController(FlightFacade flightFacade) {
        this.flightFacade = flightFacade;
    }

}
