package com.example.eatingrecord.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eatingrecord.databinding.FragmentRecommendDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecommendDetailFragment : Fragment() {

    private var _binding: FragmentRecommendDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecommendDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        renderUi()
        observe()
    }

    private fun loadData() {

    }

    private fun renderUi() {

    }

    private fun observe() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}