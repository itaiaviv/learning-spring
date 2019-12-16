package com.iaviv.training.learningspring.business.service

import com.iaviv.training.learningspring.business.domain.RoomReservation
import com.iaviv.training.learningspring.data.entity.Guest
import com.iaviv.training.learningspring.data.entity.Reservation
import com.iaviv.training.learningspring.data.entity.Room
import com.iaviv.training.learningspring.data.repository.GuestRepository
import com.iaviv.training.learningspring.data.repository.ReservationRepository
import com.iaviv.training.learningspring.data.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ReservationService @Autowired constructor(
        private val roomRepository: RoomRepository,
        private val guestRepository: GuestRepository,
        private val reservationRepository: ReservationRepository
) {

    fun getRoomReservationForDate(date: Date) : List<RoomReservation> {
        val rooms = roomRepository.findAll()
        val roomReservationMap = rooms.map{room->
            room.roomID to RoomReservation(roomId=room.roomID,
                    roomName = room.roomName,
                    roomNumber = room.roomNumber)
        }.toMap().toMutableMap()
        val reservations = reservationRepository.findReservationsByReservationDate(java.sql.Date(date.time))
        reservations.forEach {reservation ->
            val roomReservation = roomReservationMap.getValue(reservation.roomId)
            val guest = guestRepository.findById(reservation.guestId).get()
            roomReservationMap[reservation.roomId] = roomReservation.copy(date = date,firstName = guest.firstName, lastName = guest.lastName, guestId = guest.guestId)
        }
        return roomReservationMap.values.toList()
    }
    fun getAllReservations(): MutableIterable<Reservation> = reservationRepository.findAll()

    fun getAllGuests(): List<Guest> = guestRepository.findAll().toList()
    fun getGuestsByLastName(lastName: String) : List<Guest> = guestRepository.getGuestsByLastName(lastName)
    fun getGuestsByFirstName(firstName: String) : List<Guest> = guestRepository.getGuestsByFirstName(firstName)
    fun getGuestsByFirstNameAndLastName(firstName: String, lastName: String) : List<Guest> = guestRepository.getGuestsByFirstNameAndLastName(firstName, lastName)

    fun getAllRooms() : List<Room> = roomRepository.findAll().toList()
}