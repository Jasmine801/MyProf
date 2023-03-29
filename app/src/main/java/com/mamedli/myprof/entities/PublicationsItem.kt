package com.mamedli.myprof.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "publications_list")
data class PublicationsItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "allCommentCount")
    val allCommentCount: Int,

) : Serializable
