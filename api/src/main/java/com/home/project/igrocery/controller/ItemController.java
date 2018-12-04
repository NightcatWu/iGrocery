package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.repository.ItemRepository;
import com.home.project.igrocery.entity.ItemsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("testObj")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    private static List<Item> items = new ArrayList<>();

    @GetMapping("/items")
    public String displayItems(Model theModel) {

        items = itemRepository.findAll();
        ItemsForm itemsForm = new ItemsForm();
        itemsForm.setItems(items);
        theModel.addAttribute("itemsForm", itemsForm);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsForm", itemsForm);
        modelAndView.addObject("testObj", itemsForm);

        return "displayItems";

    }

    @PostMapping("/submitItems")
    public String changeItemStatus(@ModelAttribute("itemsForm") ItemsForm itemsForm, Model theModel) {

        for (Item tempItem : itemsForm.getItems()) {
            itemRepository.save(tempItem);
        }
        theModel.addAttribute("itemsForm", itemsForm);

        return "displayItems";

    }


}
