package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right
//ヒント
//DIPの講義で使用したCarのコードを参考にしましょう。
//wrongフォルダに良くない例としてスマートホームのサンプルコードを示してあります。
//サンプルコード（wrongフォルダ内）を良くみてDIPに則った形に書き直してください。
//まずは必要なインターフェースを実装しましょう
//次にアキラくんの家（class AkiraHouse)を宣言し実装しましょう
//アキラくんの家はSmartHomeのインターフェースを継承する形で定義してください。
//アキラくんの家は依存関係を注入できるようにコンストラクターの引数を設定しましょう。

class AkiraHouse(private val bulb: BulbAbstraction, private val switch: SwitchAbstraction, private val infoDisplay: InfoDisplayAbstraction): SmartHomeAbstraction{
    override var bulbWarning = false
    override var switchIsOnCounter = 0

    override fun run(){
        lighting(bulb, switch)
        if(this.switchIsOnCounter >= 5){
            this.bulbWarning = true
        }
        if(this.bulbWarning){
            infoDisplay.displayBulbWarning()
        }
    }

    private fun lighting(bulb: BulbAbstraction, switch: SwitchAbstraction, ){
        if(switch.isOn()){
            bulb.turnOn()
            switchIsOnCounter++
        }else{
            bulb.turnOff()
        }
    }
}