package kr.rhinitis.secondduoproject.item.service;

import kr.rhinitis.secondduoproject.item.dto.ItemDto;
import kr.rhinitis.secondduoproject.item.entity.Item;
import kr.rhinitis.secondduoproject.item.mapper.ItemMapper;
import kr.rhinitis.secondduoproject.item.repository.ItemRepository;
import kr.rhinitis.secondduoproject.posts.entity.Posts;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final ItemMapper mapper;

    @Override
    public ItemDto.Response createItem(ItemDto.Post postDto) {
        Item item = mapper.dtoToItem(postDto);
        itemRepository.save(item);
        return mapper.itemToResponse(item);
    }

    @Override
    public ItemDto.Response updateItem(Long itemId, ItemDto.Patch patchDto) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        item.updateItem(patchDto);
        itemRepository.save(item);
        return mapper.itemToResponse(item);
    }

    @Override
    public ItemDto.Response readItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        return mapper.itemToResponse(item);
    }

    @Override
    public MultiResponseDto readAllItem(PageRequest pageRequest) {
        Page<Item> itemPage = itemRepository.findAll(pageRequest);
        List<Item> itemList = itemPage.getContent();
        return new MultiResponseDto(mapper.itemListToResponseList(itemList), itemPage);
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
