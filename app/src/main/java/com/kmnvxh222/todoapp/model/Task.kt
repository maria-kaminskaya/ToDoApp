package com.kmnvxh222.todoapp.model

data class Task(
    val id: Long,
    val userId: Long,
    val title: String,
    val completed: Boolean
)