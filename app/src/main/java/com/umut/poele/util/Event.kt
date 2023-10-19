package com.umut.poele.util

import android.util.Log

open class Event<out T>(private val content: T){

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled){
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
    fun peekContent(): T = content
}
