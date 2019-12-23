package com.iaviv.training.learningspring.web

import com.iaviv.training.learningspring.business.domain.RoomReservation
import com.iaviv.training.learningspring.business.service.ReservationService
import com.iaviv.training.learningspring.common.DateUtils
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringJUnit4ClassRunner::class)
@WebMvcTest(RoomReservationWebController::class)
class ReservationControllerTest {

    @MockBean
    private lateinit var reservationService : ReservationService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun getReservations() {
        val date = DateUtils.createDateFromDateString("2020-01-01")
        val mockReservationList = listOf(RoomReservation(lastName="Test",firstName = "JUnit",date = date,
                guestId = 1, roomNumber = "J1",roomId = 100, roomName="JUnit Room"))
        given(reservationService.getRoomReservationForDate(date)).willReturn(mockReservationList)
        mockMvc.perform(get("/reservations?date=2020-01-01")).andExpect(status().isOk).andExpect(content().string(ArgumentMatchers.contains("Test, JUnit")))
    }
}