package com.iaviv.training.learningspring.web

/*
import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.data.entity.Guest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/guests")
class GuestWebServiceController @Autowired constructor(
        private val reservationService: ReservationService
) {
    @GetMapping
    fun getAllGuests() : List<Guest> = reservationService.getAllGuests1()

    @GetMapping
    fun getGuestByName1(@RequestParam(name="firstName", required = false) firstName: String?,
                           @RequestParam(name="lastName", required = false) lastName: String?) : List<Guest> {
        return when {
            firstName.isNullOrBlank() && lastName.isNullOrBlank() -> reservationService.getAllGuests1()
            firstName.isNullOrBlank() -> reservationService.getGuestsByLastName(lastName!!)
            lastName.isNullOrBlank() -> reservationService.getGuestsByFirstName(firstName)
            else -> reservationService.getGuestsByFirstNameAndLastName(firstName, lastName)
        }
    }
}*/
