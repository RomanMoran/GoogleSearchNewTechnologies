package com.example.googlesearchnewtechnologies.di

import com.example.googlesearchnewtechnologies.di.qualifiers.GoogleSearchAuthInterceptor
import com.example.googlesearchnewtechnologies.di.qualifiers.LoggingInterceptor
import com.example.googlesearchnewtechnologies.network.GoogleSearchInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl = "https://www.googleapis.com/"
    private const val key = "AIzaSyDiCbUEWsjdOtWjyrIXBHqkLHGhk8h_AbU"
    private const val cx = "d8c267ea4aabe5a4b"

    @Provides
    @LoggingInterceptor
    fun provideHttpLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Provides
    @GoogleSearchAuthInterceptor
    fun provideGoogleSearchInterceptor(): Interceptor {
        return GoogleSearchInterceptor(cx, key)
    }

    @Provides
    fun provideOkhttpClient(
        @LoggingInterceptor loggingInterceptor: Interceptor,
        @GoogleSearchAuthInterceptor googleAuthInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(googleAuthInterceptor)
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


}