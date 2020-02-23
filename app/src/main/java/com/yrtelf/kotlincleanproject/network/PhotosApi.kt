package com.yrtelf.kotlincleanproject.network

import com.yrtelf.kotlincleanproject.feature.PhotoEntity
import retrofit2.Call
import retrofit2.http.GET

internal interface PhotosApi {
    companion object {
        private const val PHOTOS = "photos"
    }

    @GET(PHOTOS) fun photos(): Call<List<PhotoEntity>>
}
