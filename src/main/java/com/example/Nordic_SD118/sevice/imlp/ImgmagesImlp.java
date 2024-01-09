package com.example.Nordic_SD118.sevice.imlp;

import com.example.Nordic_SD118.entity.ChiTietSanPham;
import com.example.Nordic_SD118.entity.Images;
import com.example.Nordic_SD118.repository.ImageRepositoriy;
import com.example.Nordic_SD118.sevice.ImageSevice;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgmagesImlp implements ImageSevice {
    @Autowired
    public ImageRepositoriy imagesRepository;


    public void ImagesService(ImageRepositoriy imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public Images createImages(String url, ChiTietSanPham detail) {
        Images images = new Images();
        images.setUrl(url);
        images.setParentEntity(detail);
        return imagesRepository.save(images);
    }

    public Images getImagesById(Integer id) {
        return imagesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Images not found with id: " + id));
    }

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    public Images updateImages(Integer id, String url) {
        Images images = getImagesById(id);
        images.setUrl(url);
        return imagesRepository.save(images);
    }

    public void deleteImages(Integer id) {
        Images images = getImagesById(id);
        imagesRepository.delete(images);
    }
}
