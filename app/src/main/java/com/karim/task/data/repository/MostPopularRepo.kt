package com.karim.task.data.repository


import com.karim.task.data.api.entity.WebService
import com.karim.task.data.repository.base.BaseRepo
import com.karim.task.presentation.ui.mostPopular.mapper.MostPopularMapper
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MostPopularRepo @Inject constructor(
    private val mostPopularMapper: MostPopularMapper,
    private val webService: WebService
) : BaseRepo() {

    fun getPosts() = loadFromApi {
        (webService::getPosts)(7).map {
            mostPopularMapper.mapObjectToResult(it)
        }
    }

}