package com.dothebestmayb.hiltstudy

import kotlinx.serialization.Serializable

/**
 * @author soohwan.ok
 */
@Serializable
data class NetworkResponse<T>(
    val result:String,
    val data:T,
    val errorCode: String?,
    val errorMessage:String,
)