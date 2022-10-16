package kr.rhinitis.secondduoproject.item.mapper;

import kr.rhinitis.secondduoproject.item.dto.ItemDto;
import kr.rhinitis.secondduoproject.item.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item dtoToItem(ItemDto.Post postDto);
    ItemDto.Response itemToResponse(Item item);
    List<ItemDto.Response> itemListToResponseList(List<Item> itemsList);
}