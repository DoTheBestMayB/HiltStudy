package com.dothebestmayb.hiltstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @UserQualifier(50, 180)
    @Inject
    lateinit var charles: User

    @UserQualifier(10, 120)
    @Inject
    lateinit var john: User

    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(TAG, "1) ${charles.name}")
        Log.e(TAG, "2) ${john.name}")
    }

    @Inject
    fun injectFoo(
        @CustomQualifier foo: Foo
    ) {
        Log.e(TAG, "injected Foo's id : ${foo.id}")
        this.foo = foo
    }
}