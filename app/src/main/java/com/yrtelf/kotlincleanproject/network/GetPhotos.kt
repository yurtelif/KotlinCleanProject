package com.yrtelf.kotlincleanproject.network

import com.yrtelf.kotlincleanproject.base.UseCase
import com.yrtelf.kotlincleanproject.feature.photosList.Photo
import javax.inject.Inject

class GetPhotos
@Inject constructor(private val photosRepository: PhotosRepository) : UseCase<List<Photo>, UseCase.None>() {

    override suspend fun run(params: None) = photosRepository.photos()
}
