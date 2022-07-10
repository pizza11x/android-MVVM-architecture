package com.pizza11x.androidMVVMarchitecture.data.models

open class SingleEvent<out T>(private val content: T) {

    /* VARIABLES */
    var handled = false
        private set

    /* PUBLIC FUN */
    fun getContent(): T? {
        return if (handled) {
            null
        } else {
            handled = true
            content
        }
    }

    fun peekContent(): T = content
}