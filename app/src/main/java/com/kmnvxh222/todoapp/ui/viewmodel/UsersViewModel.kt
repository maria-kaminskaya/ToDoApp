package com.kmnvxh222.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.repository.UserRepository
import javax.inject.Inject

class UsersViewModel

@Inject constructor(
    private val repositoryUser: UserRepository
)

    : ViewModel(){
//    private val repositoryUser: UserRepository  = UserRepository()
    fun getUsers(): MutableLiveData<List<User>?> {
        Log.d("UsersViewModel", repositoryUser.getUserData().value.toString())
        return repositoryUser.getUserData()
    }
}