package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Item extends AbstractEntity{

    private String name;
    private boolean bought;
    private String boughtWho;
    private Date boughtTime;
    private Date addedTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storeId")
    private Store stores;

    public Item() {}

    public Item(String name, boolean bought, String boughtWho, Date boughtTime, Date addedTime, Store stores) {
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

    public Store getStores() {
        return stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }
}
