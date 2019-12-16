package com.iaviv.training.learningspring.data.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name="RESERVATION")
data class Reservation(
        @Id
        @Column(name="RESERVATION_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val reservationId: Long,

        @Column(name="ROOM_ID")
        val roomId: Long,

        @Column(name="GUEST_ID")
        val guestId: Long,

        @Column(name="RES_DATE")
        val reservationDate: Date
)