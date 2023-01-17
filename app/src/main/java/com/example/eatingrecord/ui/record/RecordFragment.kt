package com.example.eatingrecord.ui.record

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.eatingrecord.databinding.FragmentRecordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordFragment : Fragment() {

    private lateinit var viewModel: RecordViewModel
    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding!!

    private lateinit var dayListAdapter: RecordDayAdapter
    private lateinit var dayListView: RecyclerView
    private lateinit var dateListAdapter: RecordDateAdapter
    private lateinit var dateListView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[RecordViewModel::class.java]

        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        renderUi()
        observe()
    }

    private fun loadData() {
        viewModel.setDay()
        viewModel.setDate()
    }

    private fun renderUi() {
        dayListView = binding.dayRecycler
        dayListAdapter = RecordDayAdapter()
        dayListView.adapter = dayListAdapter
        dayListView.layoutManager = StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL)

        dateListView = binding.dateRecycler
        dateListAdapter = RecordDateAdapter()
        dateListView.adapter = dateListAdapter
        dateListView.layoutManager = StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL)
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        with(viewModel) {
            dayList.observe(viewLifecycleOwner, Observer {
                dayListAdapter.submitList(it)
            })
            dateList.observe(viewLifecycleOwner, Observer {
                dateListAdapter.submitList(it)
            })
            thisMonth.observe(viewLifecycleOwner, Observer {
                binding.textMonth.text = it + "월"
            })
            thisYear.observe(viewLifecycleOwner, Observer {
                binding.textYear.text = it + "년"
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}