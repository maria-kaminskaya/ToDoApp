package com.kmnvxh222.todoapp.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.todoapp.db.model.TaskEntity
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.repository.TaskRepository
import com.kmnvxh222.todoapp.repository.UserRepository

class TaskViewModel(context: Context)


//@ViewModelInject constructor(
//    private val repositoryTask: TaskRepository,
//    private val repositoryUser: UserRepository
//)

    :ViewModel(){
    private val repositoryTask: TaskRepository = TaskRepository(context)
    private val repositoryUser: UserRepository  = UserRepository()

    fun getTask(lifecycleOwner: LifecycleOwner): MutableLiveData<List<TaskEntity>> {
        Log.d("TaskViewModel", repositoryTask.getTaskData(lifecycleOwner).value.toString())
        return repositoryTask.getTaskData(lifecycleOwner)
    }

    fun getUsers(): MutableLiveData<List<User>?> {
        Log.d("TaskViewModel", repositoryUser.getUserData().value.toString())
        return repositoryUser.getUserData()
    }
}