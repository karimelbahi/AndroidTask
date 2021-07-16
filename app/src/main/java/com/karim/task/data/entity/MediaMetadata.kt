package com.karim.task.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class MediaMetadata(
    @SerializedName("format")
    @Expose
    val format: String,
    @SerializedName("height")
    @Expose
    val height: Int,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("width")
    @Expose
    val width: Int
) : Parcelable