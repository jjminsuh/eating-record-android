package com.example.eatingrecord.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.RecordInfo
import com.example.eatingrecord.data.model.RecommendMenuInfo
import com.example.eatingrecord.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _recommendList = MutableLiveData<ArrayList<RecommendMenuInfo>>()
    val recommendList: LiveData<ArrayList<RecommendMenuInfo>> = _recommendList

    private val _recordList = MutableLiveData<ArrayList<RecordInfo>>()
    val recordList: LiveData<ArrayList<RecordInfo>> = _recordList

    private val _eventRecommendClick = MutableLiveData<Event<RecommendMenuInfo>>()
    val eventRecommendClick: LiveData<Event<RecommendMenuInfo>> = _eventRecommendClick

    private val _eventRecordClick = MutableLiveData<Event<RecordInfo>>()
    val eventRecordClick: LiveData<Event<RecordInfo>> = _eventRecordClick

    fun setRecommendList() {
        val recList: ArrayList<RecommendMenuInfo> = ArrayList()

        recList.add(RecommendMenuInfo(menuId = "0000000", menuName = "추천 1"))
        recList.add(RecommendMenuInfo(menuId = "0000000", menuName = "추천 2"))
        recList.add(RecommendMenuInfo(menuId = "0000000", menuName = "추천 3"))

        _recommendList.value = recList
    }

    fun setTodayRecord() {
        val recList: ArrayList<RecordInfo> = ArrayList()

        recList.add(RecordInfo(menuId = "0000000", menuName = "아침"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "점심"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "간식"))
        recList.add(RecordInfo(menuId = "0000000", menuName = "저녁"))

        _recordList.value = recList
    }

    fun onClickRecommend(item: RecommendMenuInfo) {
        _eventRecommendClick.value = Event(item)
    }

    fun onClickRecord(item: RecordInfo) {
        _eventRecordClick.value = Event(item)
    }
}