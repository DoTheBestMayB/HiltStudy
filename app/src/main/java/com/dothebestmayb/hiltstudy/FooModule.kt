package com.dothebestmayb.hiltstudy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FooModule {

    @CustomQualifier
    @Provides
    fun provideFoo1(): Foo {
        return Foo(id = "Foo 1")
    }

    @Provides
    fun provideFoo2(): Foo {
        return Foo(id = "Foo 2")
    }
}