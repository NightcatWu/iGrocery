package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.project.igrocery.utility.CustomItemSerializer;
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
public class Event extends AbstractEntity {

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
                fetch = FetchType.LAZY)
    @JoinTable(name = "event_item",
                joinColumns = @JoinColumn(name = "event_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
    //@JsonProperty("items")
    //@JsonSerialize(using = CustomItemSerializer.class)
    //@JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id"
    )
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {

        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);

    }
}
