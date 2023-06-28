package com.exam.sabamchedlishvili.entities;

import com.exam.sabamchedlishvili.dto.RoomDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "ROOMS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Room extends AppEntity{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "ROOM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSeq")
    private Long id;

    @Column(name = "roomNumber", nullable = false)
    private int roomNumber;

    @Column(name = "PRICE", nullable = false)
    private float price;

    public Room(RoomDTO dto){
        this.roomNumber = dto.getRoomNumber();
    }

    @ManyToOne()
    private Hotel hotel;
}
