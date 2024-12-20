package com.widget.switchkttc

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testSwitch() {
        val hsmHelper = Switch_resetHelper()
        assertEquals(hsmHelper.state(), "switch")
        hsmHelper.init()
        assertEquals(hsmHelper.state(), "off")
        hsmHelper.run("TURN")
        assertEquals(hsmHelper.state(), "on")
        hsmHelper.run("RESET")
        assertEquals(hsmHelper.state(), "off")
        hsmHelper.run("TURN")
        assertEquals(hsmHelper.state(), "on")
        hsmHelper.run("TURN")
        assertEquals(hsmHelper.state(), "off")
        hsmHelper.run("RESET")
        assertEquals(hsmHelper.state(), "off")
    }
}