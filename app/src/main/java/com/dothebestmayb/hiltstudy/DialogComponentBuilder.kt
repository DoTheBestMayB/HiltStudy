package com.dothebestmayb.hiltstudy

import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface DialogComponentBuilder {

    fun build(): DialogComponent
}