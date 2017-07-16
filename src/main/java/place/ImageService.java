package place;

import org.springframework.stereotype.Service;

@Service
class ImageService {

    final private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    byte[] getImageAsBytes(Long id){
        return getImage(id).getImageAsBytes();
    }

    private Image getImage(Long id){
        return imageRepository.findOne(id);
    }
}
