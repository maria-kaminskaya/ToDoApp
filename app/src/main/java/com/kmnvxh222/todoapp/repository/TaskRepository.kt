package com.kmnvxh222.todoapp.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kmnvxh222.todoapp.db.getAppDatabase
import com.kmnvxh222.todoapp.db.model.TaskEntity
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.network.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class TaskRepository(context: Context) {
    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private val dbDao = getAppDatabase(context).taskDao()!!
    private val threadPoolExecutor =
        ThreadPoolExecutor(1, 5, 0L, TimeUnit.SECONDS, SynchronousQueue())
    private val handler = Handler()

    fun getTaskDataRemote(): MutableLiveData<List<TaskEntity>?>{
        val taskData = MutableLiveData<List<TaskEntity>?>()
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

    fun saveTaskData(lifecycleOwner: LifecycleOwner){

        coroutineScope.launch {
            getTaskDataRemote().observe(lifecycleOwner, Observer {
                for (i in it!!){
                    dbDao.insertTask(i)
                }
            })

        }

    }
    fun getTaskData(lifecycleOwner: LifecycleOwner): MutableLiveData<List<TaskEntity>> {

        saveTaskData(lifecycleOwner)

        val list = MutableLiveData<List<TaskEntity>>()
        coroutineScope.launch {
            dbDao.getAllLiveData()?.observe(lifecycleOwner, Observer {
                list.value = it
            })
//            list.value = dbDao.getAllLiveData()?.value
        }

        return list
    }

    fun close() {
        job.cancel()
    }
}
