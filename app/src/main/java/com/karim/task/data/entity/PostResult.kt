package com.karim.task.data.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostResult(
    @SerializedName("abstract")
    @Expose
    val abstract: String,
    @SerializedName("adx_keywords")
    @Expose
    val adx_keywords: String,
    @SerializedName("asset_id")
    @Expose
    val asset_id: Long,
    @SerializedName("byline")
    @Expose
    val byline: String,
    @SerializedName("column")
    @Expose
    val column: String? = "",
    @SerializedName("des_facet")
    @Expose
    val des_facet: List<String>,
    @SerializedName("eta_id")
    @Expose
    val eta_id: Int,
    @SerializedName("geo_facet")
    @Expose
    val geo_facet: List<String>,
    @SerializedName("id")
    @Expose
    val id: Long,
    @SerializedName("media")
    @Expose
    val media: List<Media>,
    @SerializedName("nytdsection")
    @Expose
    val nytdsection: String,
    @SerializedName("org_facet")
    @Expose
    val org_facet: List<String>,
    @SerializedName("per_facet")
    @Expose
    val per_facet: List<String>,
    @SerializedName("published_date")
    @Expose
    val published_date: String,
    @SerializedName("section")
    @Expose
    val section: String,
    @SerializedName("source")
    @Expose
    val source: String,
    @SerializedName("subsection")
    @Expose
    val subsection: String,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("updated")
    @Expose
    val updated: String,
    @SerializedName("uri")
    @Expose
    val uri: String,
    @SerializedName("url")
    @Expose
    val url: String
) : Parcelable