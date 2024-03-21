package com.dothebestmayb.hiltstudy

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DefineComponent(parent = ActivityComponent::class)
interface DialogComponent {
}