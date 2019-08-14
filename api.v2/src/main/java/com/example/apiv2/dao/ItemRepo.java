package com.example.apiv2.dao;

import com.example.apiv2.model.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepo extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i WHERE (i.status, i.lastUpdatedTime) in" +
            "(SELECT j.status, j.lastUpdatedTime FROM Item j WHERE j.status = ?1)" +
            "or (i.status, i.lastUpdatedTime) in" +
            "(SELECT k.status, k.lastUpdatedTime FROM Item k WHERE k.lastUpdatedTime >= sysdate-2)")
    List<Item> findAllWithStatusAndAllIn48Hours(String status);
}
