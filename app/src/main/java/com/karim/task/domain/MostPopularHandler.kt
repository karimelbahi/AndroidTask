package com.karim.task.domain

import com.karim.task.data.repository.MostPopularRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MostPopularHandler @Inject constructor(private val repo: MostPopularRepo) {

    fun getPosts() = repo.getPosts()

}