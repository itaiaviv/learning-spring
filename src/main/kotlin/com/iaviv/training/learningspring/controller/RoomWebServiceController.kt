package com.iaviv.training.learningspring.controller

import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.data.entity.Room
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/rooms")
class RoomWebServiceController @Autowired constructor(
        private val reservationService: ReservationService
) {
    @GetMapping
    fun getAllRooms() : List<Room> = reservationService.getAllRooms()

    @PostMapping
    fun addRoom(@Valid @RequestBody room: Room) : Room = reservationService.addRoom(room)
}