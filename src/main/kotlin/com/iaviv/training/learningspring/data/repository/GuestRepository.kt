package com.iaviv.training.learningspring.data.repository

import com.iaviv.training.learningspring.data.entity.Guest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestRepository : CrudRepository<Guest, Long> {
    fun getGuestsByFirstNameAndLastName(firstName: String, lastName: String) : List<Guest>
    fun getGuestsByFirstName(firstName: String) : List<Guest>
    fun getGuestsByLastName(lastName: String) : List<Guest>
}