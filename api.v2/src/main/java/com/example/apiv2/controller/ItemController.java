package com.example.apiv2.controller;

import com.example.apiv2.dao.ItemRepo;
import com.example.apiv2.exception.ItemNotFoundException;
import com.example.apiv2.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepo repo;

    public ItemController(ItemRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    List<Item> getItems() {
        return repo.findAll();
    }

    @GetMapping("/")
    List<Item> getAllItems() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PostMapping("")
    public Item postItem(@RequestBody Item item) {
        item.setLastUpdatedTime(new Date());
        repo.save(item);
        return item;
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item newItem) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.setLastUpdatedTime(new Date());
        repo.save(newItem);

        return newItem;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        repo.delete(item);

    }


}
