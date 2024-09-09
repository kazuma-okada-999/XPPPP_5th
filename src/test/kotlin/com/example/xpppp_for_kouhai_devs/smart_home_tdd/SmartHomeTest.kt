package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.S9000
import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.SmartHomeAbstraction
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmartHomeTest {
    //ここにテストを記述してください。
    //必要なTestDoubleは自分たちで設定しましょう。
    //TestDoubleを作るのにmockkなどの便利なライブラリがありますが今回は使用しないでください。
    @Test
    fun `bulbWarning が true の時、システムを起動すると D9000 の displayBulbWarningが呼ばれる`() {
        //Given
        val testBulb = B9000()
        val testSwitch = S9000()
        val testInfoDisplay = SpyD9000()
        val testHome: SmartHomeAbstraction = AkiraHouse(testBulb, testSwitch, testInfoDisplay)

        //When
        testHome.bulbWarning = true
        testHome.run()

        //Then
        assertTrue(testInfoDisplay.displayBulbWarning_wasCalled)
    }

    @Test
    fun `bulbWarning が false の時、システムを起動すると D9000 の displayBulbWarningが呼ばれない`() {
        //Given
        val testBulb = B9000()
        val testSwitch = S9000()
        val testInfoDisplay = SpyD9000()
        val testHome: SmartHomeAbstraction = AkiraHouse(testBulb, testSwitch, testInfoDisplay)

        //When
        testHome.bulbWarning = false
        testHome.run()

        //Then
        assertFalse(testInfoDisplay.displayBulbWarning_wasCalled)
    }

    @Test
    fun ` Switch の isOn メソッドが実行された回数を switchIsOnCounter に保存する`(){
        //Given
        val testBulb = B9000()
        val testSwitch = S9000()
        val testInfoDisplay = SpyD9000()
        val testHome: SmartHomeAbstraction = AkiraHouse(testBulb, testSwitch, testInfoDisplay)

        //When
        testHome.run()
        assertEquals(1, testHome.switchIsOnCounter)
        testHome.run()
        assertEquals(2, testHome.switchIsOnCounter)
        testHome.run()

        //Then
        assertEquals(3, testHome.switchIsOnCounter)
    }

    @Test
    fun `switchIsOnCounter が５になったら、 bulbWarning を true にする`() {
        //Given
        val testBulb = B9000()
        val testSwitch = S9000()
        val testInfoDisplay = SpyD9000()
        val testHome: SmartHomeAbstraction = AkiraHouse(testBulb, testSwitch, testInfoDisplay)

        //When
        testHome.switchIsOnCounter = 3
        testHome.run()
        assertFalse(testHome.bulbWarning)
        testHome.run()

        //Then
        assertTrue(testHome.bulbWarning)

    }
}