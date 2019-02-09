package com.home.project.igrocery.controller;

import com.home.project.igrocery.entity.Event;
import com.home.project.igrocery.entity.Item;
import com.home.project.igrocery.repository.EventRepository;
import com.home.project.igrocery.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/events/{id}")
    public Event getEvent(@PathVariable int id) {
        return eventRepository.findById(id).get();
    }

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event theEvent) {
        return eventRepository.save(theEvent);
    }

    @PostMapping ("/events/{itemId}")
    public Event addEventForItem (@RequestBody Event theEvent, @PathVariable int itemId) {

        Item currentItem = itemRepository.findById(itemId).get();
        theEvent.addItem(currentItem);
        return eventRepository.save(theEvent);

    }

    @PutMapping("/events")
    public Event updateEvent(@RequestBody Event theEvent) {
        return eventRepository.save(theEvent);
    }

    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable int id) {
        Event theEvent = eventRepository.findById(id).get();
        eventRepository.delete(theEvent);
        return "Delete successfully. ";
    }

}
