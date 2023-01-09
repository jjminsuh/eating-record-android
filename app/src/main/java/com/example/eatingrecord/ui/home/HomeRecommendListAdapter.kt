package com.example.eatingrecord.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.data.model.RecommendMenuInfo
import com.example.eatingrecord.databinding.HomeRecommendItemBinding
import javax.inject.Inject

class HomeRecommendListAdapter @Inject constructor() : ListAdapter<RecommendMenuInfo, HomeRecommendListAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeRecommendItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: HomeRecommendItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendMenuInfo) {
            binding.textRecommendMenuName.text = item.menuName
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecommendMenuInfo>() {
            override fun areItemsTheSame(oldItem: RecommendMenuInfo, newItem: RecommendMenuInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RecommendMenuInfo, newItem: RecommendMenuInfo): Boolean {
                return oldItem.menuName == newItem.menuName
            }

        }
    }
}