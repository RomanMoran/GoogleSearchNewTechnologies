package com.example.googlesearchnewtechnologies.network.services

import com.example.googlesearchnewtechnologies.network.services.search.GoogleResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {

    @GET("customsearch/v1")
    suspend fun search(
        @Query("q") q: String,
        @Query("num") num: Int = 10
    ) : Response<GoogleResponseDto>

}