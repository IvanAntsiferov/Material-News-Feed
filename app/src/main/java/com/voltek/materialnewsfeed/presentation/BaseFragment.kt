package com.voltek.materialnewsfeed.presentation

import android.support.annotation.StringRes
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.voltek.materialnewsfeed.utils.CompositeDisposableComponent
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : MvpAppCompatFragment(),
        CompositeDisposableComponent {

    // Holds all disposables with input events subscriptions
    override val mDisposable = CompositeDisposable()

    // Helper methods
    protected fun toast(
            @StringRes resId: Int,
            length: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, getString(resId), length).show()
    }

    protected fun toast(
            message: String,
            length: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, message, length).show()
    }
}
