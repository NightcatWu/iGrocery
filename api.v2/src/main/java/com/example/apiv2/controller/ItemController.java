package com.example.apiv2.controller;

import com.example.apiv2.dao.ItemRepo;
import com.example.apiv2.exception.ItemNotFoundException;
import com.example.apiv2.model.Item;
import com.example.apiv2.model.Status;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepo repo;

    public ItemController(ItemRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<Item> getItems() {
        return repo.findAllWithStatusAndAllIn48Hours(Status.TODO.toString());
    }

    @GetMapping("/")
    public List<Item> getAllTodoItemms() {
        return repo.findAllWithStatusAndAllIn48Hours(Status.TODO.toString());
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
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
        item.setStatus(Status.TODO.toString());
        repo.save(item);
        return item;
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item newItem) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        item.setName(newItem.getName());
        item.setStatus(newItem.getStatus().toUpperCase());
        item.setLastUpdatedTime(new Date());
        repo.save(item);

        return item;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        repo.delete(item);

    }


}
