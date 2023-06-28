package com.exam.sabamchedlishvili.entities;


import com.exam.sabamchedlishvili.dto.HotelDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "HOTELS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Hotel  extends AppEntity{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "hotelIdSeq", sequenceName = "HOTEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelIdSeq")
    private Long id;

    @Column(name = "hotelName", nullable = false)
    private String hotelName;

    @Column(name = "hotelAddress", nullable = false)
    private String hotelAddress;

    public Hotel(HotelDTO dto){
        this.hotelName = dto.getHotelName();
    }
}
