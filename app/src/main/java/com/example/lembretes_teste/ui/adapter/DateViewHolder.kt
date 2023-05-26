package com.example.lembretes_teste.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.lembretes_teste.databinding.ItemDateBinding
import com.example.lembretes_teste.handler.DateHandler
import com.example.lembretes_teste.handler.DayEvents
import java.time.LocalDateTime

class DateViewHolder (private val viewBinding: ItemDateBinding, private val onDelete : (LocalDateTime, String) -> Unit): RecyclerView.ViewHolder (viewBinding.root) {
    private lateinit var adapter: EventAdapter
    fun bind(item: DayEvents) {
        viewBinding.dateTextview.text = DateHandler.transformDateToString(item.date)
        adapter = EventAdapter(item.events, onDelete, item.date)
        viewBinding.dateRecyclerview.adapter = adapter
    }


}