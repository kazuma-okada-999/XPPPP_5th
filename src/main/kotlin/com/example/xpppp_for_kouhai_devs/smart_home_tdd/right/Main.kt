package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right
//SmartHomeのインターフェースを宣言してください。

interface BulbAbstraction {
    fun turnOn():Unit
    fun turnOff():Unit
}

interface SwitchAbstraction {
    fun isOn(): Boolean
}

interface  InfoDisplayAbstraction {
    fun displayBulbWarning(): Unit
}

interface SmartHomeAbstraction {
    fun run(): Unit
    var bulbWarning: Boolean
    var switchIsOnCounter: Int
}

//main関数はスマートホームに必要な部品のインスタンスを作成し、アキラくんの家に依存を注入する。
//  ↓６行目から１３行目までのコメントアウトを解除してから始めてください

fun main(){
    //現状はクラスが宣言されていないのでエラーが出ていますが正しく実装できればエラーはなくなるはずです。
    val bulb = B9000()
    val switch = S9000()
    val infoDisplay = D9000()
    val smartHome = AkiraHouse(bulb, switch, infoDisplay)
//    val smartHome = AkiraHouse(bulb, switch)
    smartHome.run()
}
