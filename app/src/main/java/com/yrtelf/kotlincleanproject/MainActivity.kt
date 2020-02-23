package com.yrtelf.kotlincleanproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.yrtelf.kotlincleanproject.base.BaseActivity
import com.yrtelf.kotlincleanproject.base.BaseFragment
import com.yrtelf.kotlincleanproject.feature.photosList.PhotosListFragment

class MainActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment(): BaseFragment = PhotosListFragment()


}
