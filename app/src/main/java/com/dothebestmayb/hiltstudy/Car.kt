package com.dothebestmayb.hiltstudy

import javax.inject.Inject

class Car @Inject constructor(
    val engine: Engine
) {
}