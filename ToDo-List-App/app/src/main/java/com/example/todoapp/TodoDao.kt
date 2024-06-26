package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    fun insertTask(todoModel: TodoModel?): Long

    @Query("SELECT * FROM TodoModel WHERE isFinished = 0")
    fun getTask(): LiveData<List<TodoModel>>

//    @get:Query("Select * from TodoModel where isFinished == 0")
//    val task: LiveData<List<TodoModel?>?>?

    @Query("Update TodoModel Set isFinished = 1 where id=:uid")
    fun finishTask(uid: Long)

    @Query("Delete from TodoModel where id=:uid")
    fun deleteTask(uid: Long)
}
