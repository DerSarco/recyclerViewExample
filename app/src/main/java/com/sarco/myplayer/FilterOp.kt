package com.sarco.myplayer

import com.sarco.myplayer.Media.*

sealed class FilterOp {
    object FilterNone: FilterOp()
    class FilterByType(val type: Type): FilterOp()
}