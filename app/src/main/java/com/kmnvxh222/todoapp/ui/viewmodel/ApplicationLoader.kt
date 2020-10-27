package com.kmnvxh222.todoapp.ui.viewmodel

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.media.AudioManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.kmnvxh222.todoapp.di.AppInjector
import com.kmnvxh222.todoapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import java.util.*
import javax.inject.Inject

class ApplicationLoader : DaggerApplication() {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = applicationInjector


    init {
        instance = this
    }


    val appVersion: Int
        get() {
            try {
                val packageInfo = applicationContext.packageManager.getPackageInfo(applicationContext.packageName, 0)
                return packageInfo.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                throw RuntimeException("Could not get package name: $e")
            }

        }


    fun isTablet(): Boolean {
        try {
            if (isTablet == null) {
                isTablet = true
            }
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
            isTablet = false
        }

        return isTablet?:false
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // MultiDex.install(this)

    }

    override fun onCreate() {
        super.onCreate()
        try {
//            if (BuildConfig.DEBUG) {
//                Timber.plant(Timber.DebugTree())
//            }
            AppInjector.init(this)
            // ACRA.init(this)

//            JodaTimeAndroid.init(this)
            density = applicationContext.resources.displayMetrics.density
            Log.d("state", "app init")
            //  enabledStrictMode();
            //  refWatcher = LeakCanary.install(this);
//            TYPES = resources.getStringArray(R.array.send_types)
        } catch (e: Exception) {
            Log.e("state", e.toString())
            density = 1f
        }

    }

    companion object {
        val RU_LOCALE = Locale("RU", "ru")
        const val CODE_403 = 403//acc blocked
        const val CODE_401 = 401//session forbidden
        private val TAG = "app"
        var ADMIN_MESSAGE = ""
        var isTablet: Boolean? = null
        var density = 1f
        var TYPES: Array<String>? = null
        var screenOn: Boolean = false

        fun dp(value: Float) = Math.ceil((density * value).toDouble()).toInt()
        fun needAccessFineLocationPermission() = ContextCompat.checkSelfPermission(
            applicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED


        private var instance: ApplicationLoader? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

        fun TYPES() = TYPES
        fun checkVibrationIsOn(ctx: Context): Boolean {
            val am = ctx.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            return am.ringerMode == AudioManager.RINGER_MODE_VIBRATE || am.ringerMode == AudioManager.RINGER_MODE_SILENT

        }
    }
}