package com.example.eatingrecord.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.ProfileInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {

    private val _userInfo = MutableLiveData<ProfileInfo>()
    val userInfo: LiveData<ProfileInfo> = _userInfo

    fun setUserInfo() {
        _userInfo.value = ProfileInfo("idTest", "test", "https://github.com/jjminsuh/eating-record-android/blob/main/app/src/main/res/drawable/test.png?raw=true","test@gmail.com", 203.5, 103.0, 1, 3)
    }
}