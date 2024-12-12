package com.widget.switchkttc

import java.util.LinkedList
import java.util.Queue

class Runner(private val _helper: IQHsmStateMachineHelper?) {

    private val _eventsQueue: Queue<EventWrapper> = LinkedList()
    lateinit var targetState: String

    fun post(event: String, data: Any? = null) {
        //println("post.addQueue [$event($data)]")
        _eventsQueue.add(EventWrapper(event, data))
        while (_eventsQueue.isNotEmpty()) {
            val eventWrapper = _eventsQueue.remove()
            //println("post event [${eventWrapper.event()}, ${eventWrapper.data()}]")
            val executor = _helper?.executor(eventWrapper.event())
            executor?.executeSync(data)
        }
    }
}
