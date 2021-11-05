package com.sarco.myplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MediaAdapter(private val mediaList: List<Media>):
    RecyclerView.Adapter<MediaAdapter.ViewHolder>(){
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.view_media_item,
            parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = mediaList[position]
        holder.bind(media)
    }

    override fun getItemCount(): Int = mediaList.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val title: TextView = view.findViewById(R.id.mediaTitle)
        private val url: ImageView = view.findViewById(R.id.mediaThumb)

        fun bind(mediaItem: Media){

            title.text = mediaItem.title

            Glide.with(url)
                .load(mediaItem.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(url)

        }
    }

}