package rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import place.Place;
import place.PlaceFacade;

import java.util.List;

@RestController
@RequestMapping("/public")
class PlaceController {

    final private PlaceFacade placeFacade;

    public PlaceController(PlaceFacade placeFacade) {
        this.placeFacade = placeFacade;
    }

    @GetMapping(path ="/findPlaces")
    List<Place> findPlace(){
        return placeFacade.findAllPlacesWithImagesId();
    }

    @GetMapping(path ="/image" , produces = MediaType.APPLICATION_JSON_VALUE)
    byte[]  getImage(@RequestParam("id") Long id){
        return placeFacade.getImageForPlace(id);
    }
}
