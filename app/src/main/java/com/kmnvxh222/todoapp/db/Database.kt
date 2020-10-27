package com.kmnvxh222.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kmnvxh222.todoapp.db.dao.TaskDao
import com.kmnvxh222.todoapp.db.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao?
}

fun getAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "database"
    )
        .allowMainThreadQueries()
        .build()
}


