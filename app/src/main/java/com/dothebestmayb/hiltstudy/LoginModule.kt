package com.dothebestmayb.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object LoginModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserDataRepository(
        localDataSource: UserLocalDataSource,
        remoteDataSource: UserRemoteDataSource,
    ): UserDataRepository {
        return UserDataRepository(
            localDataSource,
            remoteDataSource,
        )
    }
}