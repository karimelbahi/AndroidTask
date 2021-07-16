package com.karim.task.data.api.entity

import com.karim.task.data.entity.MostPopularResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("v2/viewed/{id}.json?api-key=YQRL45Ewmp4sozDhJAOx7g4LCLDVbw9l")
    fun getPosts(
        @Path("id") id: Int
    ): Flow<MostPopularResponse>

}