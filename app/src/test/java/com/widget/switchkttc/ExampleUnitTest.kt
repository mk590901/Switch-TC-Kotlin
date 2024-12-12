package com.widget.switchkttc

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testSwitch() {
        val hsmHelper = SwitchResetHelper()
        hsmHelper.init()
        hsmHelper.run("TURN")
        hsmHelper.run("RESET")
        hsmHelper.run("TURN")
        hsmHelper.run("TURN")
        hsmHelper.run("RESET")
    }
}