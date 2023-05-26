package com.example.lembretes_teste.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lembretes_teste.databinding.ItemEventBinding
import java.time.LocalDateTime

class EventAdapter (private val itens: List<String>, private val onDelete : (LocalDateTime, String) -> Unit, private val dateTime: LocalDateTime): RecyclerView.Adapter<EventViewHolder>() {
    private lateinit var binding: ItemEventBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemEventBinding.inflate(inflater)
        return EventViewHolder(binding, onDelete, dateTime)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(item = itens[position])
    }
}