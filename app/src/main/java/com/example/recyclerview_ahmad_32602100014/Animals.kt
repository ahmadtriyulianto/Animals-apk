package com.example.recyclerview_ahmad_32602100014

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animals(
    val name: String,
    val description: String,
    val photo: Int,
    val keterangan: String
) : Parcelable