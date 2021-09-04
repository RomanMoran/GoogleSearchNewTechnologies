package com.example.googlesearchnewtechnologies.data.search

import com.example.googlesearchnewtechnologies.ErrorUtils
import com.example.googlesearchnewtechnologies.data.common.Result
import com.example.googlesearchnewtechnologies.network.services.SearchApiService
import com.example.googlesearchnewtechnologies.network.services.search.GoogleResponseDto
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class GoogleSearchDataSource @Inject constructor(
    private val service: SearchApiService,
    private val retrofit: Retrofit
) {

    suspend fun fetchResultsSearch(query: String): Result<GoogleResponseDto> {
        return getResponse(
            request = { service.search(query) },
            defaultErrorMessage = "Something went wrong"
        )
    }

    private suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Result<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            Result.error("Unknown Error", null)
        }
    }

}