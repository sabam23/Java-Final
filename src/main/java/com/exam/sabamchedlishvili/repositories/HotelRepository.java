package com.exam.sabamchedlishvili.repositories;

import com.exam.sabamchedlishvili.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT u FROM Hotel u")
    List<Hotel> getAll();
    @Query("SELECT u.hotelName FROM Hotel u where u.id=:#{#id}")
    String getHotelNameById(Long id);
}
