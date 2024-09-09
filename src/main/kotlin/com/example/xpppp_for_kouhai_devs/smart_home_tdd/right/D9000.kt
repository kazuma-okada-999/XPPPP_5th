package com.example.xpppp_for_kouhai_devs.smart_home_tdd.right
//ディスプレイD9000のクラスを宣言し、実装してください。
//D9000クラスはアキラくんの家に必要なインターフェースに準拠してください。

class D9000: InfoDisplayAbstraction {
    override fun displayBulbWarning(){
        print("電球を交換してくだい")
    }
}