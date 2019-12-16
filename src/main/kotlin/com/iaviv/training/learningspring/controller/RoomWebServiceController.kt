package com.iaviv.training.learningspring.controller

import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.data.entity.Room
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rooms")
class RoomWebServiceController @Autowired constructor(
        private val reservationService: ReservationService
) {
    @GetMapping("/api/rooms")
    fun getAllRooms() : List<Room> = reservationService.getAllRooms()
}