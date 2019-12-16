package com.iaviv.training.learningspring.data.repository

import com.iaviv.training.learningspring.data.entity.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : CrudRepository<Room, Long>