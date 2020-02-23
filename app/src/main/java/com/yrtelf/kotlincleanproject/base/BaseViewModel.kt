package com.yrtelf.kotlincleanproject.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernandocejas.sample.core.exception.Failure

/**
 * Base ViewModel class with default Failure handling.
 * @see ViewModel
 * @see Failure
 */
abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}