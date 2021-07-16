package com.karim.task.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MostPopularResponse(
    @SerializedName("copyright")
    @Expose
    val copyright: String,
    @SerializedName("num_results")
    @Expose
    val num_results: Int,
    @SerializedName("results")
    @Expose
    val results: List<PostResult>,
    @SerializedName("status")
    @Expose
    val status: String
)