package com.example.xpppp_for_kouhai_devs.dip.right
import DIP.Right.NormalWheel

interface WheelAbstraction {
    fun rotate(): String
}
// 下位モジュールの抽象に依存
class Car(private val wheel: WheelAbstraction ) {
    fun drive(): String {
        val wheelStatus = wheel.rotate()
        return "$wheelStatus\n車が走ります!!"
    }

    fun back(): String {
        val wheelStatus = wheel.rotate()
        return "$wheelStatus\n車がバックします!!"
    }
}



fun main () {
    val wheel = NormalWheel()
    val car= Car(wheel)
    println(car.drive())
}

//　仕様が変わってoptionWheelにしたい場合
//　上位モジュールであるCarクラスはWheelAbstractionインターフェースに依存し、
//　下位モジュールのNormalWheelには依存していない。
//　そのため、仕様が変わって新しい種類のホイールを導入する際、
//　Carクラスを変更する必要はない。
//　代わりに新しいホイールの実装を作成し、Carクラスを変更することなく
//　組み込むことができる。→拡張性向上
//　また上位クラスが具体的な実装に依存していないと、変更が必要な場合に
//　影響範囲を最小限に抑えることができる。→保守性向上
//　これが依存性逆転の原則がもたらす利点　→拡張性向上、保守性向上

