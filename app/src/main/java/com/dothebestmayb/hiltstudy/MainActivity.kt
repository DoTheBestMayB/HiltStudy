package com.dothebestmayb.hiltstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assert(this::foo.isInitialized)
    }

    @Inject
    fun injectFoo(
        @CustomQualifier foo: Foo
    ) {
        Log.e(TAG, "injected Foo's id : ${foo.id}")
        this.foo = foo
    }
}