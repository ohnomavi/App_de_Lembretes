package com.example.lembretes_teste.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lembretes_teste.databinding.ItemDateBinding
import com.example.lembretes_teste.handler.DayEvents
import java.time.LocalDateTime

class DateAdapter (private val itens: List<DayEvents>, private val onDelete : (LocalDateTime, String) -> Unit): RecyclerView.Adapter<DateViewHolder>() {
    private lateinit var binding: ItemDateBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemDateBinding.inflate(inflater)
        return DateViewHolder(binding, onDelete)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(item = itens[position])
    }


}