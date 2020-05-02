package com.picpay.desafio.android.arch

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ViewModelInterface<T: BaseViewModel> {

    val viewModel: T

    private val loadingInterface
        get() = this as LoadingInterface

    fun prepareViewModel(lifecycleOwner: LifecycleOwner){
        lifecycleOwner.lifecycle.addObserver(viewModel)
        viewModel.viewState.observe(lifecycleOwner, Observer { renderState( it ) })
    }

    fun renderState(state: ViewState?){
        when (state) {
            is LoadingState.Show -> loadingInterface.showLoading()
            is LoadingState.Hide -> loadingInterface.hideLoading()
        }
    }
}