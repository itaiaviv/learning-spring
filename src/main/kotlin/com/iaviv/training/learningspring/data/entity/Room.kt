package com.iaviv.training.learningspring.data.entity

import javax.persistence.*

@Entity
@Table(name="ROOM")
data class Room(
        @Id
        @Column(name="ROOM_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val roomID: Long,

        @Column(name="NAME")
        val roomName: String,

        @Column(name="ROOM_NUMBER")
        val roomNumber: String,

        @Column(name="BED_INFO")
        val bedInfo: String
)