package com.iaviv.training.learningspring.web

/*
@Controller
@RequestMapping("/reservations")
data class RoomReservationWebController @Autowired constructor(private val reservationService: ReservationService) {

    @GetMapping
    fun getReservations(@RequestParam(value="date", required = false)dateString: String, model: Model): String {
        val date = DateUtils.createDateFromDateString(dateString)
        val roomReservations = reservationService.getRoomReservationForDate(date)
        model.addAttribute("roomReservations",roomReservations)
        return "reservations"
    }
}*/
