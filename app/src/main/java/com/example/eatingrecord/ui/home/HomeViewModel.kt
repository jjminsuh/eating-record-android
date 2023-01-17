package com.example.eatingrecord.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.HomeRecordInfo
import com.example.eatingrecord.data.model.RecommendMenuInfo
import com.example.eatingrecord.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _recommendList = MutableLiveData<ArrayList<RecommendMenuInfo>>()
    val recommendList: LiveData<ArrayList<RecommendMenuInfo>> = _recommendList

    private val _recordList = MutableLiveData<ArrayList<HomeRecordInfo>>()
    val recordList: LiveData<ArrayList<HomeRecordInfo>> = _recordList

    private val _eventRecommendClick = MutableLiveData<Event<RecommendMenuInfo>>()
    val eventRecommendClick: LiveData<Event<RecommendMenuInfo>> = _eventRecommendClick

    fun setRecommendList() {
        val recList: ArrayList<RecommendMenuInfo> = ArrayList()

        recList.add(RecommendMenuInfo(menuName = "추천 1"))
        recList.add(RecommendMenuInfo(menuName = "추천 2"))
        recList.add(RecommendMenuInfo(menuName = "추천 3"))

        _recommendList.value = recList
    }

    fun setTodayRecord() {
        val recList: ArrayList<HomeRecordInfo> = ArrayList()

        recList.add(HomeRecordInfo(menuName = "아침"))
        recList.add(HomeRecordInfo(menuName = "점심"))
        recList.add(HomeRecordInfo(menuName = "간식"))
        recList.add(HomeRecordInfo(menuName = "저녁"))

        _recordList.value = recList
    }

    fun onClickRecommend(item: RecommendMenuInfo) {
        _eventRecommendClick.value = Event(item)
    }
}