package com.dothebestmayb.hiltstudy

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
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

    fun createUserDataRepository(): UserDataRepository {
        return UserDataRepository(createUserLocalDataSource(), createUserRemoteDataSource())
    }

    fun createLoginViewModelFactory(): AbstractSavedStateViewModelFactory {
        return object : AbstractSavedStateViewModelFactory() {
            val userDataRepository = createUserDataRepository()
            override fun <T : ViewModel> create(
                key: String, modelClass: Class<T>, handle: SavedStateHandle
            ): T {
                return LoginViewModel(userDataRepository) as T
            }

        }
    }
}