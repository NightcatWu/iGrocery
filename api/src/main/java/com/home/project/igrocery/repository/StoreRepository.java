package com.home.project.igrocery.repository;

import com.home.project.igrocery.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
