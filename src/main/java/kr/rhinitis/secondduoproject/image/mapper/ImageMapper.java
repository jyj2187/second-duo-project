package kr.rhinitis.secondduoproject.image.mapper;

import kr.rhinitis.secondduoproject.image.dto.ImageDto;
import kr.rhinitis.secondduoproject.image.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDto.Response imageToResponseDto(Image image);
    List<ImageDto.Response> imageListToResponseDtoList(List<Image> images);
}
