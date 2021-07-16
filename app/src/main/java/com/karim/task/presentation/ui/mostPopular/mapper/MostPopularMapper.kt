package com.karim.task.presentation.ui.mostPopular.mapper

import com.karim.task.data.entity.MostPopularResponse
import com.karim.task.data.entity.PostResult

interface MostPopularMapper {
    fun mapObjectToResult(meals: MostPopularResponse): List<PostResult>

}