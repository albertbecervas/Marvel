package com.abecerra.marvel_domain.usecase.base

import com.abecerra.marvel_domain.model.base.Failure
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

typealias CompletionBlock<RESULT> = (RESULT) -> Unit
typealias ErrorBlock = (Failure) -> Unit

abstract class BaseUseCase<RESULT, PARAMS> {

    private var parentJob: Job = Job()
    var backgroundContext: CoroutineContext = Dispatchers.IO
    var foregroundContext: CoroutineContext = Dispatchers.Main

    protected abstract suspend fun executeOnBackground(params: PARAMS): RESULT

    fun execute(params: PARAMS, error: ErrorBlock = {}, response: CompletionBlock<RESULT>) {
        createUseCaseJob()
        CoroutineScope(Dispatchers.Default + parentJob).launch {
            try {
                val result = withContext(backgroundContext) { executeOnBackground(params) }
                response(result)
            } catch (e: Exception) {
                error(Failure.ServerError)
            }
        }
    }

    private fun createUseCaseJob() {
        unsubscribe()
        parentJob = Job()
    }

    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }
}
