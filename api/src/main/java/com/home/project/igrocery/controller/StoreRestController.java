package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Store;
import com.home.project.igrocery.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
