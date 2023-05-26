package com.example.lembretes_teste

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.lembretes_teste.databinding.ItemDateBinding
import com.example.lembretes_teste.databinding.ItemEventBinding
import com.example.lembretes_teste.databinding.MainActivityBinding
import com.example.lembretes_teste.handler.DateHandler
import com.example.lembretes_teste.handler.DayEvents
import com.example.lembretes_teste.ui.adapter.DateAdapter
import java.time.LocalDateTime
import java.time.LocalTime

class MainActivity : Activity() {
    private lateinit var binding: MainActivityBinding
    private lateinit var dateAdapter: DateAdapter

    private val eventsList= mutableListOf<DayEvents>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dateAdapter = DateAdapter (eventsList, ::deleteEvent)
        binding.datesRecyclerview.adapter = dateAdapter
        setListener()
    }

    private fun setListener() {
        binding.criarButton.setOnClickListener {
            if (!binding.nomeEdittext.text.isNullOrEmpty() && !binding.dataEdittext.text.isNullOrEmpty()){
                insertEvent(binding.dataEdittext.text.toString(),binding.nomeEdittext.text.toString())
                dateAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun insertEvent(date: String, name: String) {
        if (eventsList.find { DateHandler.transformDateToString(it.date) == date } != null) {
            eventsList.find {
                DateHandler.transformDateToString(it.date) == date
            }?.events?.add(name)
        } else {
            DateHandler.validateStringToDate(date)?.let { dateTime ->
                eventsList.add(DayEvents(dateTime, mutableListOf(name)))
                eventsList.sortBy {
                    it.date
                }

            }
        }
    }

    private fun deleteEvent(date: LocalDateTime, name: String) {
        eventsList.find { it.date == date }?.events?.remove(name)
        if (eventsList.find { it.date == date}?.events?.size == 0)
            eventsList.removeIf{
                it.date == date
            }
        dateAdapter.notifyDataSetChanged()
    }
}