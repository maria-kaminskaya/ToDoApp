package com.kmnvxh222.todoapp.di

import com.kmnvxh222.todoapp.ui.view.FlowFragment
import com.kmnvxh222.todoapp.ui.view.TaskFragment
import com.kmnvxh222.todoapp.ui.view.UserDetailFragment
import com.kmnvxh222.todoapp.ui.view.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun getUserDetailFragment(): UserDetailFragment

    @ContributesAndroidInjector
    abstract fun getFlowFragment(): FlowFragment

    @ContributesAndroidInjector
    abstract fun getTaskFragment(): TaskFragment

    @ContributesAndroidInjector
    abstract fun getUsersFragment(): UsersFragment

}