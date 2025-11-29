package com.example.Backend.Inventory.Service.Repository;

import com.example.Backend.Inventory.Service.entity.Event;
import com.example.Backend.Inventory.Service.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

}
