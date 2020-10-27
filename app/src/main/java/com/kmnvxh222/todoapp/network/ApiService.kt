package com.kmnvxh222.todoapp.network

import com.kmnvxh222.todoapp.model.Task
import com.kmnvxh222.todoapp.model.User
import dagger.Provides
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getUsers(): Deferred<List<User>>

    @GET("/todos")
    fun getTodos(): Deferred<List<Task>>
}