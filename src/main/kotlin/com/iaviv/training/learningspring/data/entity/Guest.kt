package com.iaviv.training.learningspring.data.entity

import javax.persistence.*

@Entity
@Table(name="GUEST")
data class Guest (
        @Id
        @Column(name="GUEST_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val guestId: Long,

        @Column(name="FIRST_NAME")
        val firstName: String,

        @Column(name="LAST_NAME")
        val lastName: String,

        @Column(name="EMAIL_ADDRESS")
        val emailAddress: String,

        @Column(name="ADDRESS")
        val address: String,

        @Column(name="COUNTRY")
        val country: String,

        @Column(name="STATE")
        val state: String,

        @Column(name="PHONE_NUMBER")
        val phoneNumber: String
)