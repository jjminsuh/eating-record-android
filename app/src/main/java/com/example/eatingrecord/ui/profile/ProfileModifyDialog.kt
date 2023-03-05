package com.example.eatingrecord.ui.profile

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.eatingrecord.databinding.ProfileModifyDialogBinding

class ProfileModifyDialog : DialogFragment() {

    private lateinit var viewModel: ProfileViewModel
    private var _binding: ProfileModifyDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        _binding = ProfileModifyDialogBinding.inflate(inflater, container, false)

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
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun observe() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}