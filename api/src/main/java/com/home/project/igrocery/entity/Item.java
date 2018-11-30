package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean bought;
    private String boughtWho;
    private Date boughtTime;
    private Date addedTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", bought=" + bought +
                ", boughtWho='" + boughtWho + '\'' +
                ", boughtTime=" + boughtTime +
                ", addedTime=" + addedTime +
                ", stores=" + stores +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
