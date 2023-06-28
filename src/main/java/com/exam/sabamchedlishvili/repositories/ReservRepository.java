package com.exam.sabamchedlishvili.repositories;

import com.exam.sabamchedlishvili.entities.Reservation;
import com.exam.sabamchedlishvili.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ReservRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT u FROM Reservation u")
    List<Reservation> getAll();

    @Query("SELECT u.room.hotel.id FROM Reservation u")
    Set<Long> getAllHotelId();

    @Query("select count (*) from Reservation u where u.room.hotel.id = :#{#id}")
    int getCountReservationByHotelId(Long id);

    @Query("select sum (u.room.price) from Reservation u where u.room.hotel.id = :#{#id}")
    Long getOneNightPriceReservationByHotelId(Long id);


    @Query("select u.room from Reservation u ")
    List<Room> getBusyRooms();
}