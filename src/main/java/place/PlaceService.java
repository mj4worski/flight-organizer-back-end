package place;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
class PlaceService {

    final private PlaceRepository placeRepository;

    PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    List<Place> findPlaces(){
        Iterable<Place> places = placeRepository.findAll();
        return StreamSupport.stream(places.spliterator(), false)
                .collect(Collectors.toList());
    }

    void getAllImagesIdForPlace(Place place){
        List<BigInteger> allImagesIdForPlace = placeRepository.getAllImagesIdForPlace(place.getId());
        place.setImageIds(allImagesIdForPlace);
    }
}
