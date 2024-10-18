package com.example.dulich.DTO;

import lombok.Data;

@Data
public class RoomDTO {
    private int roomId;
    private int hotelId;
    private String roomType;
    private int price;
    private int availability;
}
