package com.kmnvxh222.todoapp.di

import androidx.lifecycle.ViewModel
import com.kmnvxh222.todoapp.ui.viewmodel.TaskViewModel
import com.kmnvxh222.todoapp.ui.viewmodel.UserDetailViewModel
import com.kmnvxh222.todoapp.ui.viewmodel.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    abstract fun bindTaskViewModel(taskViewModel: TaskViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun bindUserDetailViewModel(userDetailViewModel: UserDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    abstract fun bindUsersViewModel(usersViewModel: UsersViewModel): ViewModel
}