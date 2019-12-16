package com.iaviv.training.learningspring.data.repository

import com.iaviv.training.learningspring.data.entity.Reservation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
interface ReservationRepository : CrudRepository<Reservation,Long>{
    fun findReservationsByReservationDate(date : Date) : Iterable<Reservation>
}