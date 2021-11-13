package com.sarco.myplayer

import android.content.Context
import android.view.ContentInfo
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//object MyObject {
//
//}

//val ViewGroup.size: Int
//    get() = childCount
//
//operator fun ViewGroup.get(index: Int): View = getChildAt(index)

//fun heavyTask(): String = "Hello"

sealed class Op {
    class Add(val value: Int) :Op()
    class Sub(val value:Int): Op()
    class Mul(val value: Int): Op()
    object Inc: Op()

}

fun doOp(x: Int, op: Op): Int = when(op){
    is Op.Add -> x + op.value
    is Op.Mul -> x - op.value
    is Op.Sub -> x * op.value
    Op.Inc -> x + 1
}

fun test() {



//
//    val x: Int? = null
//    val l: Long = x?.toLong() ?: 0


//    GlobalScope.launch(Dispatchers.Main) {
//        val result = withContext(Dispatchers.IO){
//            heavyTask()
//        }
//        print(result)
//    }

//
////    propiedades de extensión
//    viewGroup.getChildAt(0)
//
////    operadores de extensión
//    viewGroup[0]
//
//


////    MyObject.x
////    MyObject.y
//
////    MainActivity.EXTRA_ID
//    val obj = object {
//        val x = 20
//        val y = "Hello"
//    }
//
//    obj.x

/*
//    colecciones
    val listOfInt: List<Int> = listOf(4, 1,5,3,2)
    val mutable: MutableList<Int> = mutableListOf(5, 7, 2, 3, 4)

    val set = setOf(1,2,3,4,5)

    val map = mapOf("A" to 1, "b" to 2)
//    destructuración de map
    for ((key, value) in map){

    }



    val emptyList = emptyList<Int>()
    val newList = listOfInt + 3
    val newList2 = emptyList + newList

    mutable.add(8)
    mutable.remove(5)

    for (i in 0.until(10)){

    }

    0 until2 10
    val result = listOfInt
        .asSequence()
        .filter { it % 2 == 0 }
        .map { it.toString() }
        .toList()
    println(result)*/

//    val res = doOp(2, 3) { _, y -> y * 2 }

//    val lazyVal by lazy {
//        20
//    }
//
//    lazyVal.toString()
}
/*
infix fun Int.until2(x: Int){

}*/

fun sum(x:Int, y: Int): Int = x + y

//se puede usar la palabra reservada invoke para ejecutar.
fun doOp(x: Int, y: Int, op: (Int, Int) -> Int) = op(x, y)