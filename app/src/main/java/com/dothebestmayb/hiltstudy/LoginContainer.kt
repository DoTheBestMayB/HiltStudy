package com.dothebestmayb.hiltstudy

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginContainer(private val appContainer: AppContainer) {

    fun createUserDataRepository(): UserDataRepository {
        return UserDataRepository(
            appContainer.createUserLocalDataSource(),
            appContainer.createUserRemoteDataSource()
        )
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