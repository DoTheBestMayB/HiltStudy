package com.dothebestmayb.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.dothebestmayb.presentation.theme.HiltStudyTheme

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltStudyTheme {
                LoginNavHost()
            }
        }
    }
}