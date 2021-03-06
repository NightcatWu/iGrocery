package com.home.project.igrocery.repository;

import com.home.project.igrocery.entity.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "from Item where bought=:bought ")
    List<Item> findAllBought(@Param("bought") Boolean boughtStatus, Sort sort);

}
