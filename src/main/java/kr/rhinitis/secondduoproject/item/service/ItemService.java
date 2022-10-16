package kr.rhinitis.secondduoproject.item.service;

import kr.rhinitis.secondduoproject.item.dto.ItemDto;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import org.springframework.data.domain.PageRequest;

public interface ItemService {
    ItemDto.Response createItem(ItemDto.Post postDto);
    ItemDto.Response updateItem(Long itemId, ItemDto.Patch patchDto);
    ItemDto.Response readItem(Long itemId);
    MultiResponseDto readAllItem(PageRequest pageRequest);
    void deleteItem(Long itemId);
}
