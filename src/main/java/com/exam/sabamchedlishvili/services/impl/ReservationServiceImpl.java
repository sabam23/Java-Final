package com.exam.sabamchedlishvili.services.impl;

import com.exam.sabamchedlishvili.dto.ApiResponse;
import com.exam.sabamchedlishvili.dto.ReservationDTO;
import com.exam.sabamchedlishvili.entities.RecordState;
import com.exam.sabamchedlishvili.entities.Reservation;
import com.exam.sabamchedlishvili.entities.Room;
import com.exam.sabamchedlishvili.repositories.HotelRepository;
import com.exam.sabamchedlishvili.repositories.ReservRepository;
import com.exam.sabamchedlishvili.repositories.RoomRepository;
import com.exam.sabamchedlishvili.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ReservRepository reservationRepository;
    @Autowired
    public ReservationServiceImpl(RoomRepository roomRepository, HotelRepository hotelRepository, ReservRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public ApiResponse addReserv(ReservationDTO roomReservation) {
        Reservation reservation = new Reservation();
        reservation.setRoom(roomRepository.getById(roomReservation.getRoomId()));
        reservation.setReservedBy(roomReservation.getReservedBy());
        reservation.setRecordState(RecordState.ACTIVE);

        return new ApiResponse("reservation",reservationRepository.save(reservation));
    }

    @Override
    public ApiResponse getReservations() {
        return new ApiResponse("reservations",reservationRepository.getAll());
    }

    @Override
    public ApiResponse getFreeRooms() {
        List<Room> busyRooms = reservationRepository.getBusyRooms();
        List<Long> ids = busyRooms.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return new ApiResponse("reservation",roomRepository.getRoomsByIdNotIn(ids));
    }

    @Override
    public ApiResponse getReservedRooms() {
        return new ApiResponse("status",reservationRepository.getBusyRooms());
    }
}
