package com.example.mobileapps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedCredentialsManager : ViewModel() {
    val login_manager = MutableLiveData<CredentialsManager>()
}