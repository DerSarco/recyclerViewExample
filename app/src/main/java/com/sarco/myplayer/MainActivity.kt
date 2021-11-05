package com.sarco.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.recycler)
        recycler.adapter = MediaAdapter(getItems())

        recycler.setOnClickListener {
            toast("Hello")
        }

        /*     val etMessage = findViewById<EditText>(R.id.etMessage)
             val btnShowMessage = findViewById<Button>(R.id.btnShowMessage)

             btnShowMessage.setOnClickListener {
                 toast("Hello ${etMessage?.text.toString()}")
        }*/

        startActivity<MainActivity>()

    }

}


