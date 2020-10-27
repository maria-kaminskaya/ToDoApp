package com.kmnvxh222.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.repository.UserRepository

class UserDetailViewModel

//@ViewModelInject constructor(
//    private val repositoryUser: UserRepository
//)

    : ViewModel(){

    private val repositoryUser: UserRepository  = UserRepository()

    fun getUsers(): MutableLiveData<List<User>?> {
        Log.d("UserDetailViewModel", repositoryUser.getUserData().value.toString())
        val listUsers = repositoryUser.getUserData()
//        val user = MutableLiveData<User?>()
////            user.value = (listUsers.value.)
//        if (listUsers.value != null){
//        for (i in listUsers.value!!){
//            if (i.id == id){
//                user.value = i
//            }
//        }}
//        Log.d("UserDetailViewModel", user.value.toString())
        return listUsers
    }
}