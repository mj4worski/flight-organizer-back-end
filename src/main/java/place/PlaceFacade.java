package place;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaceFacade {
    final private PlaceService placeService;

    final private ImageService imageService;

    public PlaceFacade(PlaceService placeService, ImageService imageService) {
        this.placeService = placeService;
        this.imageService = imageService;
    }

    public List<Place> findAllPlacesWithImagesId(){
        List<Place> places = placeService.findPlaces();
        places.forEach(placeService::getAllImagesIdForPlace);
        return places;
    }

    public byte[] getImageForPlace(Long id) {
        return imageService.getImageAsBytes(id);
    }
}
