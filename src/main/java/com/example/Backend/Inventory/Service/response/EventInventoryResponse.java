package com.example.Backend.Inventory.Service.response;

import com.example.Backend.Inventory.Service.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {

    private  String event;
    private  Long capacity;
    private  Venue venue;
}
