package com.iaviv.training.learningspring.controller

import com.iaviv.training.learningspring.business.domain.RoomReservation
import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.common.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/room-reservation")
class RoomReservationWebServiceController @Autowired constructor(
        private val reservationService: ReservationService
) {

    @GetMapping
    fun getRoomReservations(@RequestParam(name="date", required = false) dateString: String?) : List<RoomReservation>{
        val date = DateUtils.createDateFromDateString(dateString)
        return reservationService.getRoomReservationForDate(date)
    }
}
