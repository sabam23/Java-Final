package com.exam.sabamchedlishvili.repositories;

import com.exam.sabamchedlishvili.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT u FROM Room u")
    List<Room> getAll();

    List<Room> getRoomsByIdNotIn(List<Long> id);
    List<Room> getRoomsByHotelIdAndIdNotIn(Long hotelId,List<Long> id);
}
