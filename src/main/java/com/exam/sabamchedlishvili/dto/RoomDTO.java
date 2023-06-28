package com.exam.sabamchedlishvili.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDTO {
    private Long hotelId;
    private int roomNumber;
    private float price;
}
