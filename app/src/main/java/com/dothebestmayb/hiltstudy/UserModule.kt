package com.dothebestmayb.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
    @Provides
    @UserQualifier(50, 180)
    fun provideCharles(): User {
        return User("Charles")
    }

    @Provides
    @UserQualifier(10, 120)
    fun provideJohn(): User {
        return User("John")
    }
}