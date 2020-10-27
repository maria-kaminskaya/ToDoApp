package com.kmnvxh222.todoapp.di

import com.kmnvxh222.todoapp.model.Geo
import com.kmnvxh222.todoapp.model.User
import com.kmnvxh222.todoapp.repository.UserRepository
import com.kmnvxh222.todoapp.ui.viewmodel.UsersViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class RootModule {

//    @Singleton
//    @Provides
//    fun provideTaskRepository(apiService: ApiService) =
//        TaskRepository(apiService)
//
//    @Singleton
//    @Provides
//    fun provideUserRepository(apiService: ApiService) =
//        UserRepository(apiService)

//    @Singleton
//    @Provides
//    fun provideTaskViewModel(
//        repositoryTask: TaskRepository,
//        repositoryUser: UserRepository
//    ) = TaskViewModel(repositoryTask, repositoryUser)

//    @Singleton
//    @Provides
//    fun provideUserDetailViewModel(
//        repositoryUser: UserRepository
//    ) = UserDetailViewModel(repositoryUser)

//    @Singleton
//    @Provides
//    fun provideUsersViewModel(
//        repositoryUser: UserRepository
//    ) = UsersViewModel(repositoryUser)

    @Singleton
    @Provides
    fun providesServerProvider() = user

    companion object {
        val user = Geo(1111111.88,888.2222)
    }

}

