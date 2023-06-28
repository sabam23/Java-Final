package com.exam.sabamchedlishvili.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ReservationDTO {
    private Long roomId;
    private String reservedBy;
}
