package com.example.eatingrecord.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.eatingrecord.R
import com.example.eatingrecord.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        renderUi()
        observe()
    }

    private fun loadData() {
        viewModel.setUserInfo()
    }

    private fun renderUi() {

    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        with(viewModel) {
            userInfo.observe(viewLifecycleOwner, Observer {
                if(it.image == null) {
                    binding.imageProfile.setImageResource(R.drawable.ic_android_black_54dp)
                } else {
                    val url = it.image
                    Glide
                        .with(this@ProfileFragment)
                        .load(url)
                        .into(binding.imageProfile)
                }

                binding.textName.text = it.name
                binding.textEmail.text = it.email
                binding.textAgeValue.text = "${it.age}세"
                binding.textHeightValue.text = "${it.height} cm"
                binding.textWeightValue.text = "${it.weight} kg"

                when (it.sex) {
                    1 -> {
                        binding.textSexValue.setText(R.string.sex_men)
                    }
                    2 -> {
                        binding.textSexValue.setText(R.string.sex_women)
                    }
                    else -> {
                        binding.textSexValue.setText(R.string.not_select)
                    }
                }
            })

            eventModifyClick.observe(viewLifecycleOwner, Observer {
                val dialog = ProfileModifyDialog()
                dialog.show(childFragmentManager, "ProfileModifyDialog")
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}