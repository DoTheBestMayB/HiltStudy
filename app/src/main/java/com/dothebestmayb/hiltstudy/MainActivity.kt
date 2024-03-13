package com.dothebestmayb.hiltstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var foo: Foo

    @Inject
    lateinit var bar: Bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assert(this::foo.isInitialized)
        assert(this::bar.isInitialized)
        assert(foo.bar != null)
    }
}