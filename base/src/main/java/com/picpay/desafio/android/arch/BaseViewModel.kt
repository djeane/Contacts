package com.picpay.desafio.android.arch

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(), LifecycleObserver {

    val viewState = MediatorLiveData<ViewState>()

    val job = Job()

    private val loadingLiveData = mediator<LoadingState>()

    private val viewStateList: MutableList<MutableLiveData<*>> = mutableListOf()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewState.value = null
        viewStateList.forEach {
            if (it.value != null && it.value != viewState.value) {
                viewState.postValue(it.value as ViewState)
            }
        }
    }

    private fun <T : ViewState> mediator(): MutableLiveData<T> {
        val liveData = MutableLiveData<T>()
        viewState.addSource(liveData) { viewState.value = it }
        return liveData
    }

    private fun load(asyncBlock: suspend CoroutineScope.() -> Unit) {
        CoroutineScope(Dispatchers.Main + job).launch {
            showLoading()
            asyncBlock()
            hideLoading()
        }
    }

    private fun showLoading() = loadingLiveData.postValue(LoadingState.Show)

    private fun hideLoading() = loadingLiveData.postValue(LoadingState.Hide)

    override fun onCleared() {
        viewStateList.clear()
        job.cancel()
    }
}