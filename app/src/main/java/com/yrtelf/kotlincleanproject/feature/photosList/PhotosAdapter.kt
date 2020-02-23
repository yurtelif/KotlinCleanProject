package com.yrtelf.kotlincleanproject.feature.photosList

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernandocejas.sample.core.extension.inflate
import com.yrtelf.kotlincleanproject.R
import com.yrtelf.kotlincleanproject.feature.PhotoView
import com.yrtelf.kotlincleanproject.navigate.Navigator
import kotlinx.android.synthetic.main.photo_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class PhotosAdapter
@Inject constructor() : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    internal var collection: List<PhotoView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (PhotoView, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.photo_list_item))

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(collection[position], clickListener)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photoView: PhotoView, clickListener: (PhotoView, Navigator.Extras) -> Unit) {
            itemView.setOnClickListener {
                clickListener(photoView, Navigator.Extras(itemView.photoImage))
            }
        }
    }

}
