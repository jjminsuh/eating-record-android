package com.example.eatingrecord.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.data.model.RecommendMenuInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _recommendList = MutableLiveData<ArrayList<RecommendMenuInfo>>()
    val recommendList: LiveData<ArrayList<RecommendMenuInfo>> = _recommendList

    fun setRecommendList() {
        val recList: ArrayList<RecommendMenuInfo> = ArrayList()

        recList.add(RecommendMenuInfo(menuName = "추천 1"))
        recList.add(RecommendMenuInfo(menuName = "추천 2"))
        recList.add(RecommendMenuInfo(menuName = "추천 3"))

        _recommendList.value = recList
    }
}