package com.sarco.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

//funciones de extensión

fun Context.toast(msg: String, lenght: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, lenght).show()
}

fun RecyclerView.ViewHolder.toast(message: String){
    itemView.context.toast(message)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
     LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadURL(mediaUrl: String) = Glide.with(this)
    .load(mediaUrl)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .centerCrop()
    .into(this)


inline fun <reified T: Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}
