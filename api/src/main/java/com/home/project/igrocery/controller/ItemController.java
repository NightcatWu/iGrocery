package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.entity.ServiceResponse;
import com.home.project.igrocery.repository.ItemRepository;
import com.home.project.igrocery.entity.ItemsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> changeItemStatus(@RequestBody List<Item> listItems) {

//        for (Item tempItem : itemsForm.getItems()) {
//            itemRepository.save(tempItem);
//        }
//        theModel.addAttribute("itemsForm", itemsForm);
//
//        return "displayItems";

        ServiceResponse<List<Item>> response = new ServiceResponse<>("success", listItems);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }

    @GetMapping("/getAllItems")
    public ResponseEntity<Object> getAllItems() {

        items = itemRepository.findAll();
        ServiceResponse<List<Item>> response = new ServiceResponse<>("success", items);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }


}
