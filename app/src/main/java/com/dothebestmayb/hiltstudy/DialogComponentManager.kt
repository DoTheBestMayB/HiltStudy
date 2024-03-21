package com.dothebestmayb.hiltstudy

import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject

class DialogComponentManager @Inject constructor(
    private val dialogComponentBuilder: DialogComponentBuilder
) : GeneratedComponentManager<DialogComponent> {
    override fun generatedComponent(): DialogComponent {
        return dialogComponentBuilder.build()
    }
}