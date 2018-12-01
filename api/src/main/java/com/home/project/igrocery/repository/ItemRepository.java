package com.home.project.igrocery.repository;

import com.home.project.igrocery.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
