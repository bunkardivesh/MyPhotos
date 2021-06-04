package com.divesh.myphotos

data class Dogs(
    val url: String,
    val breeds : ArrayList<Breeds>
)

data class Breeds(
    val name : String?
)