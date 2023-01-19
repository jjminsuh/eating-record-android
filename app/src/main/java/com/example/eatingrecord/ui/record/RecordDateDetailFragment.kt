package com.example.eatingrecord.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.databinding.FragmentRecordDateDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordDateDetailFragment : Fragment() {

    private lateinit var viewModel: RecordDateDetailViewModel
    private var _binding: FragmentRecordDateDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuListAdapter: RecordDateDetailMenuAdapter
    private lateinit var menuListView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[RecordDateDetailViewModel::class.java]

        _binding  = FragmentRecordDateDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: RecordDateDetailFragmentArgs by navArgs()
        val fullDate = args.date

        loadData(fullDate)
        renderUi()
        observe()
    }

    private fun loadData(fullDate: String) {
        viewModel.setDate(fullDate)
        viewModel.setRecordMenuList()
    }

    private fun renderUi() {
        menuListView = binding.recyclerRecord
        menuListAdapter = RecordDateDetailMenuAdapter()
        menuListView.adapter = menuListAdapter
        menuListView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observe() {
        with(viewModel) {
            date.observe(viewLifecycleOwner, Observer {
                binding.textDate.text = "${it.year}년 ${it.month}월 ${it.date}일"
            })
            recordMenuList.observe(viewLifecycleOwner, Observer {
                menuListAdapter.submitList(it)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}