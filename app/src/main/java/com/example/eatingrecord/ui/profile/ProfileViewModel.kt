package com.example.eatingrecord.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.ProfileInfo
import com.example.eatingrecord.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel() {

    private val _userInfo = MutableLiveData<ProfileInfo>()
    val userInfo: LiveData<ProfileInfo> = _userInfo

    private val _eventModifyClick = MutableLiveData<Event<ProfileInfo>>()
    val eventModifyClick: LiveData<Event<ProfileInfo>> = _eventModifyClick

    fun setUserInfo() {
        _userInfo.value = ProfileInfo("idTest", "test", "https://github.com/jjminsuh/eating-record-android/blob/main/app/src/main/res/drawable/test.png?raw=true","test@gmail.com", 25,203.5, 103.0, 1, 3)
    }

    fun onClickModify(info: ProfileInfo) {
        _eventModifyClick.value = Event(info)
    }
}