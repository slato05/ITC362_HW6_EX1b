package com.example.itc362_hw6_ex1b

import java.util.*

data class Crime(
    val id: UUID,
    var title: String,
    val date: Date,
    var isSolved: Boolean
)