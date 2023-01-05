package com.example.eatingrecord.util

import androidx.lifecycle.Observer


open class Event<T> (private val content: T) {

    private var isHandled = false

    fun getContentIfNotHandled(): T? {
        return if (isHandled) {
            null
        } else {
            isHandled = true
            content
        }
    }

    fun peekContent() : T = content
}

class EventObserver<T> (private val onEventHandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventHandledContent(value)
        }
    }
}