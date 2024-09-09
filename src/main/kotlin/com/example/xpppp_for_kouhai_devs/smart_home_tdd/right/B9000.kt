package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right
//バルブB9000のクラスを宣言し、実装してください。
//B9000クラスはアキラくんの家に必要なインターフェースを継承してください。

class B9000: BulbAbstraction {

    override fun turnOn(){
        print("照明が点灯しました")
    }
    override fun turnOff() {
        print("照明が消灯しました")
    }
}