package com.kmnvxh222.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.repository.TaskRepository
import com.kmnvxh222.todoapp.repository.UserRepository

class TaskViewModel


//@ViewModelInject constructor(
//    private val repositoryTask: TaskRepository,
//    private val repositoryUser: UserRepository
//)

    :ViewModel(){
    private val repositoryTask: TaskRepository = TaskRepository()
    private val repositoryUser: UserRepository  = UserRepository()

    fun getTask(): MutableLiveData<List<Task>?> {
        Log.d("TaskViewModel", repositoryTask.getTaskData().value.toString())
        return repositoryTask.getTaskData()
    }

    fun getUsers(): MutableLiveData<List<User>?> {
        Log.d("TaskViewModel", repositoryUser.getUserData().value.toString())
        return repositoryUser.getUserData()
    }
}