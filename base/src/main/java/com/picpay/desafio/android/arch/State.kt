package com.picpay.desafio.android.arch

interface ViewState

sealed class LoadingState : ViewState {
    object Show : LoadingState()
    object Hide : LoadingState()
}