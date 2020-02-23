package com.yrtelf.kotlincleanproject.feature.photosList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.fernandocejas.sample.core.extension.visible
import com.yrtelf.kotlincleanproject.R
import com.yrtelf.kotlincleanproject.base.BaseFragment
import com.yrtelf.kotlincleanproject.extension.observe
import com.yrtelf.kotlincleanproject.extension.viewModel
import com.yrtelf.kotlincleanproject.feature.PhotoView
import kotlinx.android.synthetic.main.fragment_photos_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PhotosListFragment : BaseFragment() {

    @Inject
    lateinit var photosAdapter: PhotosAdapter

    private lateinit var photosViewModel: PhotosViewModel

    override fun layoutId() = R.layout.fragment_photos_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        photosViewModel = viewModel(viewModelFactory) {
            observe(photos, ::renderPhotosList)
            //failure(failure, ::handleFailure)
        }

    }

    private fun renderPhotosList(photos: List<PhotoView>?) {
        photosAdapter.collection = photos.orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiliazeView()
        loadPhotoList()
    }

    private fun initiliazeView() {
        photoList.adapter = photosAdapter
    }

    private fun loadPhotoList() {
        photoList.visible()
        photosViewModel.loadPhotos()
    }


}
