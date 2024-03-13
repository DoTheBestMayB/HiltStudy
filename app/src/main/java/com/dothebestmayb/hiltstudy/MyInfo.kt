package com.dothebestmayb.hiltstudy

import java.util.UUID

class MyInfo {

    var uuid = UUID.randomUUID()

    override fun toString(): String {
        return uuid.toString()
    }
}