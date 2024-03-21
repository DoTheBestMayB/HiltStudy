package com.dothebestmayb.hiltstudy

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import java.time.LocalDateTime

@EntryPoint
@InstallIn(DialogComponent::class)
interface DialogEntryPoint {

    fun getUser(): User

    fun getRandomNumber(): Int

    fun getLocalDateTime(): LocalDateTime
}