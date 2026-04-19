package com.example.lost_found.Service;

import com.example.lost_found.DTO.ItemRequest;
import com.example.lost_found.Entity.Item;
import com.example.lost_found.Entity.User;
import com.example.lost_found.Repository.ItemRepository;
import com.example.lost_found.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public Item addItem(ItemRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Item item = new Item();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setLocation(request.getLocation());
        item.setStatus(request.getStatus());
        item.setUser(user);

        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
