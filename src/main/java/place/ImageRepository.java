package place;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ImageRepository extends CrudRepository<Image, Long>{
}
