package com.dothebestmayb.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @IntoSet
    fun provideOneString(): String {
        return "ABC"
    }

    @Provides
    @ElementsIntoSet
    fun provideMultipleString(): Set<String> {
        return setOf("DEF", "GHI")
    }
}