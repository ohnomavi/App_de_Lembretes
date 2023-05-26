package com.example.lembretes_teste.handler

import android.util.Log
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


object DateHandler {
    private val pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    fun validateStringToDate(date: String): LocalDateTime? {
        val formattedDate: LocalDateTime = try {
            LocalDate.parse(date, pattern).atStartOfDay()
        } catch (e: DateTimeParseException) {
            return null
        }

        val instant = LocalDateTime.now()
        return if (formattedDate.isAfter(instant))
            formattedDate
        else
            null
    }

    fun transformDateToString (localDateTime: LocalDateTime): String {
        return localDateTime.format(pattern)
    }
}
