package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Store extends AbstractEntity {

    private String name;
    private String category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "store_item",
                joinColumns = @JoinColumn(name = "store_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    public Store() {}

    public Store(String name, String category, List<Item> items) {
        this.name = name;
        this.category = category;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", items=" + items +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
