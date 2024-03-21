package com.dothebestmayb.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlin.random.Random

@Module
@InstallIn(DialogComponent::class)
object DialogModule {

    @Provides
    fun provideUser(): User {
        return User("James")
    }

    @Provides
    fun provideRandomNumber(): Int {
        return Random.nextInt(1000)
    }
}