package com.yrtelf.kotlincleanproject

import android.app.Application
import com.yrtelf.kotlincleanproject.di.ApplicationComponent
import com.yrtelf.kotlincleanproject.di.ApplicationModule
import com.yrtelf.kotlincleanproject.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}
