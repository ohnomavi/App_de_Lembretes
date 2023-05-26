package com.example.lembretes_teste.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lembretes_teste.databinding.ItemEventBinding
import java.time.LocalDateTime

class EventViewHolder (private val viewBinding: ItemEventBinding, private val onDelete : (LocalDateTime, String) -> Unit, private val dateTime: LocalDateTime): RecyclerView.ViewHolder (viewBinding.root) {
    fun bind(item: String) {
        viewBinding.eventTextview.text = item
        viewBinding.deleteEvent.setOnClickListener { onDelete (dateTime, item) }
    }
}