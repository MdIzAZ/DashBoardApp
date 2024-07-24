package com.practice.dashboardapp.data.remote

import com.practice.assignmentapp.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer ${Constants.TOKEN}")
        return chain.proceed(request.build())
    }
}