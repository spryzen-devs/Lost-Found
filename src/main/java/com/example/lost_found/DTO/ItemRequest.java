package com.example.lost_found.DTO;

import lombok.Data;

@Data
public class ItemRequest {
    private String name;
    private String description;
    private String location;
    private String status;
    private Long userId;
}
