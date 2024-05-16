package com.dothebestmayb.data.usecase

import com.dothebestmayb.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor() : LoginUseCase {
    override suspend fun invoke(id: String, password: String): Result<String> {
        return runCatching {
            "token"
        }
    }
}