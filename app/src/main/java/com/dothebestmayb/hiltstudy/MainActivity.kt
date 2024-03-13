package com.dothebestmayb.hiltstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    @Inject
    fun injectFoo(
        @Named("foo1") foo: Foo
    ) {
        Log.e(TAG, "injected Foo's id : ${foo.id}")
        this.foo = foo
    }
}