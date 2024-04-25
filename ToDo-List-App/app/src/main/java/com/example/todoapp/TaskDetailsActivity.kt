package com.example.todoapp

// TaskDetailsActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_item)

        // Retrieve task ID from intent extras
        val taskId = intent.getIntExtra("taskId", -1)
        // Use the task ID to fetch task details from the database or any other data source
        // Populate the views in the layout with the task details
    }
}
