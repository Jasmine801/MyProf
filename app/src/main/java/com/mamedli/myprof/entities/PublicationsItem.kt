package com.mamedli.myprof.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class PublicationsItem(
    val id: Int?,
    val title: String,
    val description: String,
    val allCommentCount: Int,
)
