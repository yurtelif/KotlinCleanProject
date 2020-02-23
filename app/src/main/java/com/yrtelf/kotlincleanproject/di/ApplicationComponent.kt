package com.yrtelf.kotlincleanproject.di

import com.yrtelf.kotlincleanproject.AndroidApplication
import com.yrtelf.kotlincleanproject.di.viewModel.ViewModelModule
import com.yrtelf.kotlincleanproject.feature.photosList.PhotosListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    //fun inject(routeActivity: RouteActivity)
    fun inject(photosListFragment: PhotosListFragment)
}