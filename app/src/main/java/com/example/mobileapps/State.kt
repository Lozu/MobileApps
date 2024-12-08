package com.example.mobileapps

object State {
    val login_manager: CredentialsManager
    init {
        login_manager = CredentialsManager(true)
    }
}