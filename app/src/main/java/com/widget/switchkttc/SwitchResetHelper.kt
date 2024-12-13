package com.widget.switchkttc

class SwitchResetHelper {
    private val helper_ = QHsmHelper("switch")

    init {
        createHelper()
    }

    // fun switchEntry(data: Any? = null) {
    // }
    //
    // fun switchInit(data: Any? = null) {
    // }

    fun offEntry(data: Any? = null) {
        println("OFF")
    }

    fun offReset(data: Any? = null) {
        println("@RESET")
    }

    // fun offExit(data: Any? = null) {
    // }

    fun offTurn(data: Any? = null) {
        println("OFF: TURN")
    }

    fun onEntry(data: Any? = null) {
        println("ON ")
    }

    // fun onExit(data: Any? = null) {
    // }

    fun onTurn(data: Any? = null) {
        println("ON : TURN")
    }

    fun init() {
        helper_.post("init")
    }

    fun run(eventName: String) {
        helper_.post(eventName)
    }

    fun state() : String {
        return helper_.getState()
    }

    private fun createHelper() {
        helper_.insert("switch", "init", ThreadedCodeExecutor(helper_, "off", listOf(
            // ::switchEntry,
            // ::switchInit,
            ::offEntry,
        )))
        helper_.insert("off", "RESET", ThreadedCodeExecutor(helper_, "off", listOf(
            ::offReset,
            // ::offExit,
            // ::switchInit,
            ::offEntry,
        )))
        helper_.insert("off", "TURN", ThreadedCodeExecutor(helper_, "on", listOf(
            ::offTurn,
            ::onEntry,
        )))
        helper_.insert("on", "RESET", ThreadedCodeExecutor(helper_, "off", listOf(
            ::offReset,
            // ::onExit,
            // ::offExit,
            // ::switchInit,
            ::offEntry,
        )))
        helper_.insert("on", "TURN", ThreadedCodeExecutor(helper_, "off", listOf(
            ::onTurn,
            // ::onExit,
            // ::offExit,
            // ::switchInit,
            ::offEntry,
        )))
    }
}
