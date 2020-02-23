package com.yrtelf.kotlincleanproject.feature

import com.yrtelf.kotlincleanproject.feature.photosList.Photo

data class PhotoEntity(
    private val albumId: Int,
    private val id: Int,
    private val title: String,
    private val url: String,
    private val thumbnailUrl: String
) {
    fun toMovie() = Photo(
        albumId,
        id,
        title,
        url,
        thumbnailUrl
    )
}