package com.widget.switchkttc

class QHsmHelper(private var _state: String) : IQHsmStateMachineHelper {

    private val runner: Runner = Runner(this)
    private val _container: MutableMap<String, ThreadedCodeExecutor> = mutableMapOf()

    fun insert(state: String, event: String, executor: ThreadedCodeExecutor) {
        _container[createKey(state, event)] = executor
    }

    fun post(event: String, data: Any? = null) {
        runner.post(event, data)
    }

    override fun executor(event: String): ThreadedCodeExecutor? {
        val key = createKey(_state, event)
        if (!_container.containsKey(key)) {
            println("runSync.error: $_state->$event")
            return null
        }
        val executor = _container[key]
        return executor
    }

    override fun getState(): String {
        return _state
    }

    override fun setState(state: String) {
        _state = state
    }

    private fun createKey(state: String, event: String): String {
        // Assuming createKey is a method that concatenates state and event with a delimiter
        return "$state:$event"
    }

}
