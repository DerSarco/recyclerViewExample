package com.sarco.myplayer

import android.content.Context
import android.view.ContentInfo
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

fun test() {


//    val res = doOp(2, 3) { _, y -> y * 2 }

    val lazyVal by lazy {
        20
    }

    lazyVal.toString()
}

fun sum(x:Int, y: Int): Int = x + y

//se puede usar la palabra reservada invoke para ejecutar.
fun doOp(x: Int, y: Int, op: (Int, Int) -> Int) = op(x, y)