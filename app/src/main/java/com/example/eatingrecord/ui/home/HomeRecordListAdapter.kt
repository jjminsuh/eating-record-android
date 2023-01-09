package com.example.eatingrecord.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.data.model.HomeRecordInfo
import com.example.eatingrecord.databinding.HomeRecordItemBinding
import javax.inject.Inject

class HomeRecordListAdapter @Inject constructor() : ListAdapter<HomeRecordInfo, HomeRecordListAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeRecordItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: HomeRecordItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeRecordInfo) {
            binding.textRecommendMenuName.text = item.menuName
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HomeRecordInfo>() {
            override fun areItemsTheSame(oldItem: HomeRecordInfo, newItem: HomeRecordInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: HomeRecordInfo, newItem: HomeRecordInfo): Boolean {
                return oldItem.menuName == newItem.menuName
            }

        }
    }
}