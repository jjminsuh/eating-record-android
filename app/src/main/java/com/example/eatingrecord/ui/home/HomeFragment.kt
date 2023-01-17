package com.example.eatingrecord.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.data.model.RecommendMenuInfo
import com.example.eatingrecord.databinding.FragmentHomeBinding
import com.example.eatingrecord.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recommendListAdapter: HomeRecommendListAdapter
    private lateinit var recommendListView: RecyclerView
    private lateinit var recordListAdapter: HomeRecordListAdapter
    private lateinit var recordListView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        renderUi()
        observe()
    }

    private fun loadData() {
        viewModel.setRecommendList()
        viewModel.setTodayRecord()
    }

    private fun renderUi() {
        recommendListView = binding.recyclerRecommend
        recommendListAdapter = HomeRecommendListAdapter(object: RecommendDetailListener{
            override fun onClickRecommend(menu: RecommendMenuInfo) {
                viewModel.onClickRecommend(menu)
            }
        })
        recommendListView.adapter = recommendListAdapter
        recommendListView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recordListView = binding.recyclerTodayRecord
        recordListAdapter = HomeRecordListAdapter()
        recordListView.adapter = recordListAdapter
        recordListView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observe() {
        with(viewModel) {
            recommendList.observe(viewLifecycleOwner, Observer {
                recommendListAdapter.submitList(it)
            })
            recordList.observe(viewLifecycleOwner, Observer {
                recordListAdapter.submitList(it)
            })
            eventRecommendClick.observe(viewLifecycleOwner, EventObserver {
                val action = HomeFragmentDirections.actionNavigationHomeToNavigationHomeRecommendDetail(it.menuName)
                Navigation.findNavController(requireView()).navigate(action)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
