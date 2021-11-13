package com.sarco.myplayer

import androidx.annotation.WorkerThread
import com.sarco.myplayer.Media.*

//fun getItems(): List<Media> = listOf(
//    Media("https://placekitten.com/g/200/200?image=1", "Title 1", Type.VIDEO),
//    Media("https://placekitten.com/g/200/200?image=2", "Title 2", Type.PHOTO),
//    Media("https://placekitten.com/g/200/200?image=3", "Title 3" , Type.PHOTO),
//    Media("https://placekitten.com/g/200/200?image=4", "Title 4", Type.VIDEO),
//    Media("https://placekitten.com/g/200/200?image=5", "Title 5", Type.PHOTO),
//    Media("https://placekitten.com/g/200/200?image=6", "Title 6", Type.VIDEO),
//    Media("https://placekitten.com/g/200/200?image=7", "Title 7", Type.VIDEO),
//    Media("https://placekitten.com/g/200/200?image=8", "Title 8", Type.PHOTO),
//    Media("https://placekitten.com/g/200/200?image=9", "Title 9", Type.PHOTO),
//
//
//)

object MediaProvider {
//    esto nos indica que no podemos ejecutar la función en el hilo principal
    @WorkerThread
    fun getItems(): List<Media> {
        Thread.sleep(2000)
        return (1..10).map {
            Media(
                it,
                "https://placekitten.com/200/200?image=$it",
                "Title $it",
                if(it%3 ==0) Type.VIDEO else Type.PHOTO)
        }
    }
}



//
//    fun getItems(): List<Media> {
//        val list = mutableListOf<Media>()
//        for (x in 1 until  10) {
//            list.add(Media(
//                "https://placekitten.com/g/200/200?image=$x", "Title $x",
//                when (x % 3) {
//                    0 -> Type.VIDEO
//                    else -> Type.PHOTO
//                }
//            ))
//        }
//        return list.toList()
//    }
