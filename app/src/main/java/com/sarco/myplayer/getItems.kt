package com.sarco.myplayer

import com.sarco.myplayer.Media.*

fun getItems(): List<Media> = listOf(
    Media("https://placekitten.com/g/200/200?image=1", "Title 1", Type.VIDEO),
    Media("https://placekitten.com/g/200/200?image=2", "Title 2", Type.PHOTO),
    Media("https://placekitten.com/g/200/200?image=3", "Title 3" , Type.PHOTO),
    Media("https://placekitten.com/g/200/200?image=4", "Title 4", Type.VIDEO),
    Media("https://placekitten.com/g/200/200?image=5", "Title 5", Type.PHOTO),
    Media("https://placekitten.com/g/200/200?image=6", "Title 6", Type.VIDEO),
    Media("https://placekitten.com/g/200/200?image=7", "Title 7", Type.VIDEO),
    Media("https://placekitten.com/g/200/200?image=8", "Title 8", Type.PHOTO),
    Media("https://placekitten.com/g/200/200?image=9", "Title 9", Type.PHOTO),


)