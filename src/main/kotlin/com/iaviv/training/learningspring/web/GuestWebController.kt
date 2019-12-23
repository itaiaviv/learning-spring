package com.iaviv.training.learningspring.web

import com.iaviv.training.learningspring.business.service.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/guests")
class GuestWebController @Autowired constructor(
        private val reservationService: ReservationService
) {
    @GetMapping
    fun getGuestByName(@RequestParam(name="firstName", required = false) firstName: String?,
                           @RequestParam(name="lastName", required = false) lastName: String?, model: Model) : String {
        val guests = when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> reservationService.getAllGuests()
            firstName.isNullOrBlank() -> reservationService.getGuestsByLastName(lastName!!)
            lastName.isNullOrBlank() -> reservationService.getGuestsByFirstName(firstName)
            else -> reservationService.getGuestsByFirstNameAndLastName(firstName, lastName)
        }
        model.addAttribute("guests",guests)
        return "guests"
    }
}
