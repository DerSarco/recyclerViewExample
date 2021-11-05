package com.sarco.myplayer

data class Media(val url: String, val title: String, val type: Type){
    enum class Type { PHOTO, VIDEO }
}

