package com.example.lost_found.Controller;

import com.example.lost_found.DTO.ItemRequest;
import com.example.lost_found.Entity.Item;
import com.example.lost_found.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public Item addItem(@RequestBody ItemRequest itemRequest) {
        return itemService.addItem(itemRequest);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.findAll();
    }
}
