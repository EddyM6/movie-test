package com.example.moviesapplication.core.mvi

sealed class UiStatus {

    object Loading: UiStatus()
    object Success : UiStatus()
    data class Failed(val message: String = "") : UiStatus()
}