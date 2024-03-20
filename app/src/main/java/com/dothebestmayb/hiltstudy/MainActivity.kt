package com.dothebestmayb.hiltstudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    @Inject
    lateinit var oneString: Set<String>

    @Inject
    lateinit var map: Map<Animal, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(TAG, map[Animal.CAT].orEmpty())
        Log.e(TAG, map[Animal.DOG].orEmpty())
        Log.e(TAG, map[Animal.PIG].orEmpty()) // 바인딩 하지 않았기 때문에 빈 값이 출력된다.
    }
}