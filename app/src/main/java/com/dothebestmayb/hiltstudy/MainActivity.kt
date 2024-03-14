package com.dothebestmayb.hiltstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var lazyFoo1: Lazy<Foo>

    @Inject
    lateinit var lazyFoo2: Lazy<Foo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assert(lazyFoo1 === lazyFoo2)
        assert(lazyFoo1.get() === lazyFoo2.get())
    }
}