package com.example.lembretes_teste.handler

import java.time.LocalDateTime

data class DayEvents(
    val date: LocalDateTime,
    val events: MutableList <String>
)
