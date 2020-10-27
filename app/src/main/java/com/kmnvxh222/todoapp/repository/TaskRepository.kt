package com.kmnvxh222.todoapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.network.ApiService
import com.kmnvxh222.todoapp.network.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskRepository {
    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getTaskData(): MutableLiveData<List<Task>?>{
        val taskData = MutableLiveData<List<Task>?>()
        try {
            coroutineScope.launch {
                val response = RetrofitApi.retrofitApiService.getTodos()
                taskData.value = response.await()
                Log.d("TaskRepository", "getTaskData ${taskData.value}")
            }
        } catch (e: Exception) {
            Log.d("TaskRepository", "error ${e}")
        }
        return taskData
    }

    fun close() {
        job.cancel()
    }
}
