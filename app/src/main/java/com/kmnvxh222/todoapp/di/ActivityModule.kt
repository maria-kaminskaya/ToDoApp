package com.kmnvxh222.todoapp.di

import com.kmnvxh222.todoapp.ui.view.MainActivity
import com.kmnvxh222.todoapp.ui.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMain(): MainActivity
    abstract fun contributeSplash(): SplashActivity
}