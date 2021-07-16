package com.karim.task.presentation.ui.mostPopular.mapper

import com.karim.task.data.entity.MostPopularResponse
import com.karim.task.data.entity.PostResult
import javax.inject.Inject

class MostPopularMapperImpl @Inject constructor():MostPopularMapper {
    override fun mapObjectToResult(mostPopular: MostPopularResponse): List<PostResult> {
        return mostPopular.results
    }
}