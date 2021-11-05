package com.sarco.myplayer

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarco.myplayer.Media.*
import com.sarco.myplayer.databinding.ViewMediaItemBinding
import kotlin.properties.Delegates


class MediaAdapter(mediaList: List<Media>, private val listener: (Media) -> Unit):
    RecyclerView.Adapter<MediaAdapter.ViewHolder>(){
    private lateinit var context: Context

    private var mediaList: List<Media> by Delegates.observable(mediaList){_, _, _ ->
            notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = mediaList[position]
        holder.bind(media)
        holder.itemView.setOnClickListener { listener(media) }
    }

    override fun getItemCount(): Int = mediaList.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(mediaItem: Media){
            with(binding){
                mediaTitle.text = mediaItem.title
                mediaThumb.loadURL(mediaItem.url)

                mediaVideoIndicator.visibility = when(mediaItem.type){
                    Type.PHOTO -> View.GONE
                    Type.VIDEO -> View.VISIBLE
                }
            }
        }

    }

}