package com.widget.switchkttc

class EventWrapper(private val _event: String, private val _data: Any?) {

    fun data(): Any? {
        return _data
    }

    fun event(): String {
        return _event
    }
}
