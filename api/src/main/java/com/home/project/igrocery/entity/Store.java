package com.home.project.igrocery.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.home.project.igrocery.utility.CustomItemSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store extends AbstractEntity {

    private String name;
    private String category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "store_item",
                joinColumns = @JoinColumn(name = "store_id"),
                inverseJoinColumns = @JoinColumn(name = "item_id"))
    @JsonProperty("items")
    @JsonSerialize(using = CustomItemSerializer.class)
    private List<Item> items;

}
