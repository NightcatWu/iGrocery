package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.project.igrocery.utility.CustomItemSerializer;
import com.home.project.igrocery.utility.CustomStoreSerializer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class Item extends AbstractEntity {

    private String name;
    private boolean bought;
    private String boughtWho;
    private Date boughtTime;
    private Date addedTime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "store_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id"))
    @JsonProperty("stores")
    @JsonSerialize(using = CustomStoreSerializer.class)
    private List<Store> stores;

    public Item() {}

    public Item(String name, boolean bought, String boughtWho, Date boughtTime, Date addedTime, List<Store> stores) {
        this.name = name;
        this.bought = bought;
        this.boughtWho = boughtWho;
        this.boughtTime = boughtTime;
        this.addedTime = addedTime;
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", bought=" + bought +
                ", boughtWho='" + boughtWho + '\'' +
                ", boughtTime=" + boughtTime +
                ", addedTime=" + addedTime +
                ", stores=" + stores +
                '}';
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

    public Date getBoughtTime() {
        return boughtTime;
    }

    public void setBoughtTime(Date boughtTime) {
        this.boughtTime = boughtTime;
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
