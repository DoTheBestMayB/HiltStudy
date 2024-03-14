package com.dothebestmayb.hiltstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var providerFoo1: Provider<Foo>

    @Inject
    lateinit var providerFoo2: Provider<Foo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foo1 = providerFoo1.get()
        val foo2 = providerFoo1.get()

        assert(foo1 !== foo2)
    }
}