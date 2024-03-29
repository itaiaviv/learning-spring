package com.iaviv.training.learningspring.controller

import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.data.entity.Guest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/guests")
class GuestWebServiceController @Autowired constructor(
        private val reservationService: ReservationService
) {
    @GetMapping
    fun getGuestByName(@RequestParam(name="firstName", required = false) firstName: String?,
                           @RequestParam(name="lastName", required = false) lastName: String?) : List<Guest> {
        return when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> reservationService.getAllGuests()
            firstName.isNullOrBlank() -> reservationService.getGuestsByLastName(lastName!!)
            lastName.isNullOrBlank() -> reservationService.getGuestsByFirstName(firstName)
            else -> reservationService.getGuestsByFirstNameAndLastName(firstName, lastName)
        }
    }

    @PostMapping
    fun addGuest(@Valid @RequestBody guest: Guest) : Guest = reservationService.addGuest(guest)
}
