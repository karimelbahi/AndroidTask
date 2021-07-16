package com.karim.task.presentation.ui.mostPopular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.karim.task.data.api.entity.Resource
import com.karim.task.domain.MostPopularHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MostPopularModel @Inject constructor(private val handler: MostPopularHandler) :
    ViewModel() {

    val postsData = flow {
        emit(Resource.loading(null))
        emitAll(handler.getPosts())
    }.asLiveData()
}