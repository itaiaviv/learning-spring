package com.iaviv.training.learningspring.data.repository

import com.iaviv.training.learningspring.data.entity.Guest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestRepository : CrudRepository<Guest, Long> {
    fun getGuestsByFirstNameAndLastNameIgnoreCase(firstName: String, lastName: String) : List<Guest>
    fun getGuestsByFirstNameIgnoreCase(firstName: String) : List<Guest>
    fun getGuestsByLastNameIgnoreCase(lastName: String) : List<Guest>
}