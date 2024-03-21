package com.dothebestmayb.hiltstudy

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import java.time.LocalDateTime

@DefineComponent.Builder
interface DialogComponentBuilder {

    // setter를 사용할 때 반드시 BindsInstance를 적어야 한다.
    fun setLocalDateTime(@BindsInstance localDateTime: LocalDateTime) : DialogComponentBuilder

    fun build(): DialogComponent
}