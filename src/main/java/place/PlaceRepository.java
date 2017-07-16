package place;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query(value = "select place_images.images_id from place_images where place_images.place_id = ?1" , nativeQuery = true)
    List<BigInteger> getAllImagesIdForPlace(Long placeId);
}
