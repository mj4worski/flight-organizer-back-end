package rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path ="/image/{id}" , produces = MediaType.IMAGE_JPEG_VALUE)
    byte[]  getImage(@PathVariable(value = "id" , required = true) Long id){
        return placeFacade.getImageForPlace(id);
    }
}
