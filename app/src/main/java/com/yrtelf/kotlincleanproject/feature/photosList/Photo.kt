package com.yrtelf.kotlincleanproject.feature.photosList

import com.fernandocejas.sample.core.extension.empty

data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {

    companion object {
        fun empty() = Photo(
            0,
            0,
            String.empty(),
            String.empty(),
            String.empty()
        )
    }
}
