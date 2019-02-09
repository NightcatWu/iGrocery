package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.project.igrocery.utility.CustomEventSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item extends AbstractEntity {

    private String name;
    private boolean bought;
    private String boughtWho;

    //@Temporal(TemporalType.DATE)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
//    private Date boughtTime;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
//    private Date addedTime;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
                fetch = FetchType.LAZY)
    @JoinTable(name = "event_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    //@JsonProperty("events")
    //@JsonSerialize(using = CustomEventSerializer.class)
    //@JsonBackReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id"
    )
    private List<Event> events;

//    private int addToEventId;
//
//    public int getAddToEventId() {
//        return addToEventId;
//    }
//
//    public void setAddToEventId(int addToEventId) {
//        this.addToEventId = addToEventId;
//    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public String getBoughtWho() {
        return boughtWho;
    }

    public void setBoughtWho(String boughtWho) {
        this.boughtWho = boughtWho;
    }

    public void addEvent(Event event) {

        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);

    }

}
