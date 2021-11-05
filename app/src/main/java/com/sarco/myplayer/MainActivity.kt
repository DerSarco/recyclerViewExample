package com.sarco.myplayer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sarco.myplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val adapter: MediaAdapter by lazy {
        MediaAdapter(getItems()) { toast(it.title) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        val textView: TextView = TextView(this).apply2 {
            text = "Hello"
            hint = "GoodBye"
            textSize = 20f
        }

    }

}

fun <T> T.apply2(body: T.() -> Unit): T{
    this.body()
    return this
}


//fun <T, U> T.run2(body: T.() -> U): U{
//    return this.body()
//}


//fun <T, U> T.let2(body: (T) -> U): U{
//    return body(this)
//}

//fun <T, U> with2(receiver: T, body: T.() -> U): U{
//    return receiver.body()
//}

//fun <T> T.also2(body: (T) -> Unit): T{
//    body(this)
//    return this
//}

