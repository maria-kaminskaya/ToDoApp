package com.kmnvxh222.todoapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.network.ApiService
import com.kmnvxh222.todoapp.network.RetrofitApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepository {
    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun getUserData(): MutableLiveData<List<User>?> {
        val userData = MutableLiveData<List<User>?>()
        try {
            coroutineScope.launch {
                val response = RetrofitApi.retrofitApiService.getUsers()
                userData.value = response.await()
                Log.d("UserRepository", "getUserData ${userData.value}")
            }
        } catch (e: Exception) {
            Log.d("UserRepository", "error ${e}")
        }
        return userData
    }

    fun close() {
        job.cancel()
    }
}