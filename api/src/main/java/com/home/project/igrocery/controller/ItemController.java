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

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("testObj")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    private static List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String displayItems() {

        return "displayItems";

    }

    @PostMapping("/submitItems")
    public ResponseEntity<Object> changeItemStatus(@RequestBody List<Item> listItems) {

        for (Item tempItem : listItems) {
            itemRepository.save(tempItem);
        }
        ServiceResponse<List<Item>> response = new ServiceResponse<>("success", listItems);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }

    @GetMapping("/getAllItems")
    public ResponseEntity<Object> getAllItems(Model theModel) {

        items = itemRepository.findAll();
        ServiceResponse<List<Item>> response = new ServiceResponse<>("success", items);
        return new ResponseEntity<Object>(response, HttpStatus.OK);

    }

}
