package com.yrtelf.kotlincleanproject.feature

import android.os.Parcel
import com.yrtelf.kotlincleanproject.utils.KParcelable
import com.yrtelf.kotlincleanproject.utils.parcelableCreator

data class PhotoView(val id: Int, val thumbnail: String) : KParcelable {

    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::PhotoView)
    }

    constructor(parcel: Parcel) : this(parcel.readInt(), parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeInt(id)
            writeString(thumbnail)
        }
    }

}
