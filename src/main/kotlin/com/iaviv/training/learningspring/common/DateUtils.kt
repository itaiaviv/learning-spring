package com.iaviv.training.learningspring.common

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd")

    fun createDateFromDateString(dateString: String?) : Date {
        return try{
            if(dateString.isNullOrBlank()) Date()
            else DATE_FORMAT.parse(dateString)
        }catch (e: ParseException){
            Date()
        }
    }
}