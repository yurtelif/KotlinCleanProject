package com.yrtelf.kotlincleanproject.feature.photosList

import androidx.lifecycle.MutableLiveData
import com.yrtelf.kotlincleanproject.base.BaseViewModel
import com.yrtelf.kotlincleanproject.base.UseCase
import com.yrtelf.kotlincleanproject.feature.PhotoView
import com.yrtelf.kotlincleanproject.network.GetPhotos
import javax.inject.Inject

class PhotosViewModel
@Inject constructor(private val getPhotos: GetPhotos) : BaseViewModel() {

    var photos: MutableLiveData<List<PhotoView>> = MutableLiveData()

    fun loadPhotos() = getPhotos(UseCase.None()) { it.fold(::handleFailure, ::handlePhotoList) }

    private fun handlePhotoList(photos: List<Photo>) {
        this.photos.value = photos.map { PhotoView(it.id, it.thumbnailUrl) }
    }

}


