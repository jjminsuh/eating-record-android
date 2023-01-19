package com.example.eatingrecord.ui.record

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eatingrecord.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import java.util.GregorianCalendar
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor() : ViewModel() {

    private val _thisYear = MutableLiveData<String>()
    val thisYear: LiveData<String> = _thisYear

    private val _thisMonth = MutableLiveData<String>()
    val thisMonth: LiveData<String> = _thisMonth

    private val _dateList = MutableLiveData<ArrayList<String>>()
    val dateList: LiveData<ArrayList<String>> = _dateList

    private val _dayList = MutableLiveData<ArrayList<String>>()
    val dayList: LiveData<ArrayList<String>> = _dayList

    private val _eventDateClick = MutableLiveData<Event<String>>()
    val eventDateClick: LiveData<Event<String>> = _eventDateClick

    fun setDay() {
        _dayList.value = arrayListOf("일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일")
    }

    fun setDate() {
        val today = GregorianCalendar()
        val dates: ArrayList<String> = ArrayList()

        try {
            _thisYear.value = today.get(Calendar.YEAR).toString()
            _thisMonth.value = (today.get(Calendar.MONTH) + 1).toString()

            val firstDayOfMonth =
                GregorianCalendar(today.get(Calendar.YEAR), today.get(Calendar.MONTH), 1, 0, 0, 0)

            val firstDay = firstDayOfMonth.get(Calendar.DAY_OF_WEEK) - 1
            val lastDay = firstDayOfMonth.getActualMaximum(Calendar.DATE) + 1

            for (i in 0 until firstDay) {
                dates.add("EMPTY")
            }

            for (i in 1 until lastDay) {
                dates.add(i.toString())
            }

            _dateList.value = dates
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("Error", e.toString())
        }
    }

    fun onClickDate(date: String) {
        _eventDateClick.value = Event(date)
    }
}