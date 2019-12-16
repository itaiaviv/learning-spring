package com.iaviv.training.learningspring.business.domain

import java.util.*

data class RoomReservation(val roomId: Long, val guestId: Long? = null,
                           val roomName: String, val roomNumber: String,
                           val firstName: String? = null, val lastName: String? = null,
                           val date: Date? = null)