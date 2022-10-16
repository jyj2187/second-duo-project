package kr.rhinitis.secondduoproject.image.repository;

import kr.rhinitis.secondduoproject.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
