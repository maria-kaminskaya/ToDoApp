package com.kmnvxh222.todoapp.di

import android.app.Application
import com.kmnvxh222.todoapp.ui.viewmodel.ApplicationLoader
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RootModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<ApplicationLoader> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: ApplicationLoader)
}