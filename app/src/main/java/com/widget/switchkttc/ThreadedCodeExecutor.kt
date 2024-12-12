package com.widget.switchkttc

class ThreadedCodeExecutor(
    private val _helper: IQHsmStateMachineHelper,
    private val _targetState: String,
    private val _functions: List<(Any?) -> Unit>
) {

    private var runner: Runner = Runner(_helper)

    fun post(event: String, data: Any? = null) {
        runner.post(event, data)
    }

    fun executeSync(data: Any? = null) {
        _helper.setState(_targetState)
        for (func in _functions) {
            func(data)
        }
    }
}
