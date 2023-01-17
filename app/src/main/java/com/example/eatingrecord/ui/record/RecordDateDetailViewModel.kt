package com.example.eatingrecord.ui.record

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.DateInfo
import com.example.eatingrecord.data.model.RecordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordDateDetailViewModel @Inject constructor() : ViewModel() {

    private val _date = MutableLiveData<DateInfo>()
    val date: LiveData<DateInfo> = _date

    private val _recordMenuList = MutableLiveData<ArrayList<RecordInfo>>()
    val recordMenuList: LiveData<ArrayList<RecordInfo>> = _recordMenuList

    fun setDate(date: String) {
        val token = date.split("-")
        _date.value = DateInfo(token[0], token[1], token[2])
    }

    fun setRecordMenuList() {
        val recList: ArrayList<RecordInfo> = ArrayList()

        recList.add(RecordInfo(menuId = "0000000", menuName = "아침"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "점심"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "간식"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "저녁"))

        _recordMenuList.value = recList
    }
}