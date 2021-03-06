package com.karim.task.data.repository.base

import com.karim.task.data.api.GeneralErrorHandler
import com.karim.task.data.api.entity.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

open class BaseRepo {
    @Inject
    lateinit var errorHandler: GeneralErrorHandler

    protected fun loadFromApi(api: () -> Flow<Any>) =
        api.invoke().catch {
            it.printStackTrace()
            emit(it)
        }.transform {
            if (it is Exception) {
                emit(Resource.error(errorHandler.getErrorMessage(errorHandler.getError(it)), it))
            } else {
                emit(Resource.success(it))
            }
        }
}