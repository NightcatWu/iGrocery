package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public String displayItems(Model theModel) {

        List<Item> itemsList = itemRepository.findAll();
        theModel.addAttribute("itemsList", itemsList);
        return "displayItems";

    }

}
