package com.picpay.desafio.android.arch

import androidx.lifecycle.MutableLiveData

class RepositoryResult<T>(
    private val value: T? = null
) {
    fun <R> notifySuccess(liveData: MutableLiveData<R>, transform: (T) -> R): RepositoryResult<T> {
        if (value != null) liveData.postValue(transform(value))
        return this
    }
}