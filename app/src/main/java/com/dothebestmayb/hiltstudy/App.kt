package com.dothebestmayb.hiltstudy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    val appContainer: AppContainer = AppContainer(this)
}