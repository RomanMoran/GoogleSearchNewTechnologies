package com.example.googlesearchnewtechnologies.data.search

import com.example.googlesearchnewtechnologies.data.common.Result
import com.example.googlesearchnewtechnologies.network.services.search.GoogleResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GoogleSearchRepositoryImpl @Inject constructor(
    private val googleDataSource: GoogleSearchDataSource
) {

    suspend fun search(query: String): Flow<Result<GoogleResponseDto>> {
        return flow {
            emit(Result.loading())
            val result = googleDataSource.fetchResultsSearch(query)
            if (result.status == Result.Status.SUCCESS) {
                val resultsItem = result.data?.items
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}