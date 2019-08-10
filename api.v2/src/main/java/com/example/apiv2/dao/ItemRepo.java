package com.example.apiv2.dao;

import com.example.apiv2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepo extends JpaRepository<Item, Integer> {
}
