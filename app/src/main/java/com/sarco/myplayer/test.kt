package com.sarco.myplayer

import android.util.Log

interface Logger {

    val tag: String
        get() = javaClass.simpleName

    fun logD(message: String){
        Log.d(tag, message)
    }

    fun logE(message: String){
        Log.e(tag, message)
    }

}