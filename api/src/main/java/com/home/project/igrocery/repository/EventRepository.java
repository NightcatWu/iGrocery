package com.home.project.igrocery.repository;

import com.home.project.igrocery.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
