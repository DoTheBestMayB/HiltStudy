package com.dothebestmayb.hiltstudy

import javax.inject.Inject

class MyName @Inject constructor() {

    override fun toString(): String {
        return "패스트캠퍼스"
    }
}