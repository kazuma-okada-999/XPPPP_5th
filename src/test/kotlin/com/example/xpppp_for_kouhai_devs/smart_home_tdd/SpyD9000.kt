package com.example.xpppp_for_kouhai_devs.smart_home_tdd

import com.example.xpppp_for_kouhai_devs.smart_home_tdd.right.InfoDisplayAbstraction

class SpyD9000:InfoDisplayAbstraction {
    var displayBulbWarning_wasCalled = false

    override fun displayBulbWarning(){
        displayBulbWarning_wasCalled = true
    }
}