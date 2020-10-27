package com.kmnvxh222.todoapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kmnvxh222.todoapp.db.model.TaskEntity
import com.kmnvxh222.todoapp.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM task")
    fun getAllLiveData(): LiveData<List<TaskEntity>>?
}
