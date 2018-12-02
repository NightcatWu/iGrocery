package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.entity.Store;
import com.home.project.igrocery.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreRestController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores")
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }


    @GetMapping("/stores/{id}")
    public Store getStore(@PathVariable int id) {
        return storeRepository.findById(id).get();
    }

    @PostMapping("/stores")
    public Store addStore(@RequestBody Store theStore) {
        return storeRepository.save(theStore);
    }

    @PutMapping("/stores")
    public Store updateStore(@RequestBody Store theStore) {
        return storeRepository.save(theStore);
    }

    @DeleteMapping("/stores/{id}")
    public String deleteStore(@PathVariable int id) {
        Store theStore = storeRepository.findById(id).get();
        storeRepository.delete(theStore);
        return "Delete successfully. ";
    }

}
