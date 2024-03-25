package com.dothebestmayb.hiltstudy

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class AppContainer(private val context: Context) {

    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:7132/api/")
            .addConverterFactory(Json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    fun createLoginRetrofitService(): LoginRetrofitService {
        return createRetrofit().create(LoginRetrofitService::class.java)
    }

    fun createUserLocalDataSource(): UserLocalDataSource {
        return UserLocalDataSource(context)
    }

    fun createUserRemoteDataSource(): UserRemoteDataSource {
        return UserRemoteDataSource(createLoginRetrofitService())
    }

    var loginContainer: LoginContainer? = null
}