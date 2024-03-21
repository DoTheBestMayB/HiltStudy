package com.dothebestmayb.hiltstudy

import android.content.Context
import android.util.Log
import dagger.hilt.EntryPoints


// @Inject constructor()와 같이 생성자 바인딩을 못한다고 가정
class FooManager {

    val TAG = FooManager::class.java.simpleName
    fun doSomeThing(context: Context) {
        val fooEntryPoint = EntryPoints.get(context, FooEntryPoint::class.java)
        val foo = fooEntryPoint.getFoo()

        Log.e(TAG, "foo = $foo")
    }
}