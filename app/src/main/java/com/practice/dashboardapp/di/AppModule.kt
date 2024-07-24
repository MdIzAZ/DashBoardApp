package com.practice.dashboardapp.di

import com.practice.dashboardapp.data.remote.AssignmentApi
import com.practice.dashboardapp.data.remote.AuthInterceptor
import com.practice.dashboardapp.data.repo.DashBoardRepoImp
import com.practice.dashboardapp.domain.repo.DashBoardRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    }


    @Provides
    @Singleton
    fun provideDashBoardApiService(okHttpClient: OkHttpClient): AssignmentApi {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl("https://api.inopenapp.com/api/v1/")
            .build()

        return retrofit.create(AssignmentApi::class.java)
    }




    @Provides
    @Singleton
    fun provideImageRepository(
        apiService: AssignmentApi,
    ): DashBoardRepo {
        return DashBoardRepoImp(apiService)
    }

}