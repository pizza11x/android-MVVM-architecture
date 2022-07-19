package com.pizza11x.androidmvvmarchitecture.data.models

import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class SingleEvent<out T> private constructor(private val content: T) {

    /* VARIABLES */
    private var handled = false

    /* PUBLIC FUN */
    fun <R> executeEvent(block: (T) -> R): SingleEvent<T> {
        if (!handled) {
            handled = true
            block(content)
        }
        return this
    }

    fun peekContent(): T = content


    override fun equals(other: Any?): Boolean {
        if (other is SingleEvent<*>) {
            return handled == other.handled && peekContent() == other.peekContent()
        }
        return false
    }
    override fun hashCode(): Int {
        return super.hashCode()
    }


    /* COMPANION FUN */
    companion object {

        fun <T : Any> T.toSingleEvent(): SingleEvent<T> = SingleEvent(this)
        fun <T> LiveData<SingleEvent<T>>.observeSingle(
            lifecycleOwner: LifecycleOwner,
            @NonNull observer: Observer<T>
        ) = observe(lifecycleOwner) { event ->
            event.executeEvent { observer.onChanged(it) }

        }
    }
}