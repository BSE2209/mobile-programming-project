package com.example.todoapp

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.TaskDetailsActivity
import com.google.android.material.card.MaterialCardView

class TaskItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cardView: MaterialCardView = itemView.findViewById(R.id.cardView)

    fun bind(context: Context) {
        cardView.setOnClickListener {
            val intent = Intent(context, TaskDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }
}
