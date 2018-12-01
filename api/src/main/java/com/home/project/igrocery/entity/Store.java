package com.home.project.igrocery.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store extends AbstractEntity {

    private String name;
    private String category;

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
