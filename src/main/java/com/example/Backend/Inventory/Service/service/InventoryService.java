package com.example.Backend.Inventory.Service.service;

import com.example.Backend.Inventory.Service.Repository.EventRepository;
import com.example.Backend.Inventory.Service.Repository.VenueRepository;
import com.example.Backend.Inventory.Service.entity.Event;
import com.example.Backend.Inventory.Service.entity.Venue;
import com.example.Backend.Inventory.Service.response.EventInventoryResponse;
import com.example.Backend.Inventory.Service.response.VenueInventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {


    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public  InventoryService(final EventRepository eventRepository, final VenueRepository venueRepository){
        this.eventRepository=eventRepository;
        this.venueRepository=venueRepository;
    }

    public List<EventInventoryResponse> getAllEvents(){
        final List<Event> events=eventRepository.findAll();

        return events.stream()
                .map(event -> EventInventoryResponse.builder()
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(event.getVenue())
                .build()).collect(Collectors.toList());

    }

    public VenueInventoryResponse getVenueInformation(final Long venueId){
        final Venue venue=venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found with id " + venueId));

        return VenueInventoryResponse.builder()
                .venueId(venue.getId())
                .venueName(venue.getName())
                .totalCapacity(venue.getTotalCapacity())
                .build();

    }
}
