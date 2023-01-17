package com.example.eatingrecord.ui.home

import com.example.eatingrecord.data.model.RecommendMenuInfo

interface RecommendDetailListener {
    fun onClickRecommend(menu: RecommendMenuInfo)
}