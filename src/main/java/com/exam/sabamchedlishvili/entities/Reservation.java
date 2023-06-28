package com.exam.sabamchedlishvili.entities;

import com.exam.sabamchedlishvili.dto.ReservationDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "RESERVATIONS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reservation extends AppEntity{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "roomReservationIdSeq", sequenceName = "RESERVATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomReservationIdSeq")
    private Long id;

    @Column(name = "RESERVED_BY")
    private String reservedBy;


    public Reservation(ReservationDTO dto){
        this.reservedBy = dto.getReservedBy();
    }
    @ManyToOne()
    private Room room;
}
