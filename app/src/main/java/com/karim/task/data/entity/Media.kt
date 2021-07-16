package com.karim.task.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    @SerializedName("approved_for_syndication")
    @Expose
    val approved_for_syndication: Int,
    @SerializedName("caption")
    @Expose
    val caption: String,
    @SerializedName("copyright")
    @Expose
    val copyright: String,
    @SerializedName("media-metadata")
    @Expose
    val media_metadata: List<MediaMetadata>,
    @SerializedName("subtype")
    @Expose
    val subtype: String,
    @SerializedName("type")
    @Expose
    val type: String
) : Parcelable