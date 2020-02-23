package com.yrtelf.kotlincleanproject.navigate

import android.view.View
import java.net.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(private val authenticator: Authenticator) {


    class Extras(val transitionSharedElement: View)


}

