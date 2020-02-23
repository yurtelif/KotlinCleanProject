package com.yrtelf.kotlincleanproject.network

import com.yrtelf.kotlincleanproject.feature.PhotoEntity
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotosService
@Inject constructor(retrofit: Retrofit) : PhotosApi {
    private val photosApi by lazy { retrofit.create(PhotosApi::class.java) }

    override fun photos(): Call<List<PhotoEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}