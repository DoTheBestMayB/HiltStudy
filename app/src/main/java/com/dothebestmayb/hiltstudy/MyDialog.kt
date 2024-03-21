package com.dothebestmayb.hiltstudy

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import dagger.hilt.EntryPoints
import javax.inject.Inject

class MyDialog @Inject constructor(
    private val context: Context,
    private val dialogComponentManager: DialogComponentManager
): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val entryPoint = EntryPoints.get(dialogComponentManager, DialogEntryPoint::class.java)
        val user = entryPoint.getUser()

        setContentView(TextView(context).apply {
            text = "${user.name}"
        })
    }
}