package com.kmnvxh222.todoapp.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task")
data class TaskEntity(
    val id: Long,
    val userId: Long,
    val title: String,
    val completed: Boolean
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var key: Long = 0
}