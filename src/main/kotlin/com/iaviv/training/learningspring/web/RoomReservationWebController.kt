package com.iaviv.training.learningspring.web

import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.common.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/reservations")
data class RoomReservationWebController @Autowired constructor(private val reservationService: ReservationService) {

    @GetMapping
    fun getReservations(@RequestParam(value="date", required = false)dateString: String?, model: Model): String {
        val date = DateUtils.createDateFromDateString(dateString)
        val roomReservations = reservationService.getRoomReservationForDate(date)
        model.addAttribute("roomReservations",roomReservations)
        return "reservations"
    }
}
