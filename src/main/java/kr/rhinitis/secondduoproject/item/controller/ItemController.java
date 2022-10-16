package kr.rhinitis.secondduoproject.item.controller;

import kr.rhinitis.secondduoproject.item.dto.ItemDto;
import kr.rhinitis.secondduoproject.item.service.ItemService;
import kr.rhinitis.secondduoproject.util.dto.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item/add")
    public String addForm() {
        return "item/addItem";
    }

    @PostMapping("/item/add")
    public String postItem(ItemDto.Post ItemDto) {
        ItemDto.Response responseDto = itemService.createItem(ItemDto);
        return "redirect:/items/" + responseDto.getItemId();
    }

    @GetMapping("/item/{item-id}")
    public String getItem(@PathVariable("item-id") Long itemId, Model model) {
        ItemDto.Response responseDto = itemService.readItem(itemId);
        model.addAttribute("item", responseDto);
        return "items/item";
    }

    @GetMapping("/items")
    public String getItems(@PageableDefault(page = 1, sort = "itemId", direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(), pageable.getSort());
        MultiResponseDto responseDto = itemService.readAllItem(pageRequest);
        model.addAttribute("items", responseDto);
        return "items";
    }

    @GetMapping("/item/edit/{item-id}")
    public String editForm(@PathVariable("item-id") Long itemId, Model model) {
        ItemDto.Response responseDto = itemService.readItem(itemId);
        model.addAttribute("item", responseDto);
        return "item/editItem";
    }

    @PostMapping("/item/edit/{item-id}")
    public String patchItem(@PathVariable("item-id") Long itemId,
                            ItemDto.Patch patchDto) {
        ItemDto.Response responseDto = itemService.updateItem(itemId, patchDto);
        return "redirect:/item/" + responseDto.getItemId();
    }

    @PostMapping("/item/{item-id}")
    public String deleteItem(@PathVariable("item-id") Long itemId) {
        itemService.deleteItem(itemId);
        return "redirect:/item";
    }
}
