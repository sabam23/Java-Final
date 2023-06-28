package com.exam.sabamchedlishvili.services.impl;

import com.exam.sabamchedlishvili.dto.*;
import com.exam.sabamchedlishvili.entities.Hotel;
import com.exam.sabamchedlishvili.entities.RecordState;
import com.exam.sabamchedlishvili.entities.Room;
import com.exam.sabamchedlishvili.modal.HotelStats;
import com.exam.sabamchedlishvili.repositories.HotelRepository;
import com.exam.sabamchedlishvili.repositories.ReservRepository;
import com.exam.sabamchedlishvili.repositories.RoomRepository;
import com.exam.sabamchedlishvili.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final ReservRepository reservationRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository, ReservRepository reservationRepository){
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ApiResponse add(HotelDTO hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setHotelAddress(hotelDto.getHotelAddress());
        hotel.setRecordState(RecordState.ACTIVE);

        return new ApiResponse("status", hotelRepository.save(hotel));
    }

    @Override
    public ApiResponse getAllHotel() {
        return new ApiResponse("hotels",hotelRepository.findAll());
    }

    @Override
    public ApiResponse getFreeRooms(Long id) {
        List<Room> busyRooms = reservationRepository.getBusyRooms();
        List<Long> ids = busyRooms.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return new ApiResponse("reservation",roomRepository.getRoomsByHotelIdAndIdNotIn(id,ids));
    }

    @Override
    public List<RoomDTO> getRoomsByHotel(List<Long> hotelIds) {
        return null;
    }

    @Override
    public ApiResponse stats() {
        List<HotelStats> sales = new ArrayList<>();
        Set<Long> hotelIds = reservationRepository.getAllHotelId();
        for (Long i : hotelIds){
            HotelStats model = new HotelStats();
            model.setHotelName(hotelRepository.getHotelNameById(i));
            model.setRentRoomNumb(reservationRepository.getCountReservationByHotelId(i));
            long price = reservationRepository.getOneNightPriceReservationByHotelId(i);
            model.setTotal(price);
            sales.add(model);
        }
        return new ApiResponse("sales", sales);
    }
}
