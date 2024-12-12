package com.widget.switchkttc

interface IQHsmStateMachineHelper {
    fun getState(): String
    fun setState(state: String)
    fun executor(event: String): ThreadedCodeExecutor?
}