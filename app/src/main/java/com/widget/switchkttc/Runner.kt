package com.widget.switchkttc

import java.util.LinkedList
import java.util.Queue

class Runner(private val _helper: IQHsmStateMachineHelper?) {

    private val _eventsQueue: Queue<EventWrapper> = LinkedList()

    fun post(event: String, data: Any? = null) {
        _eventsQueue.add(EventWrapper(event, data))
        while (_eventsQueue.isNotEmpty()) {
            val eventWrapper = _eventsQueue.remove()
            val executor = _helper?.executor(eventWrapper.event())
            executor?.executeSync(data)
        }
    }
}
