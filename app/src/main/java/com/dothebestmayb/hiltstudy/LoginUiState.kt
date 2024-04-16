package com.dothebestmayb.hiltstudy

/**
 * @author soohwan.ok
 */
data class LoginUiState(
    val id:String,
    val pw:String,
    val userState: UserState = UserState.NONE
)