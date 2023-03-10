package com.example.eatingrecord.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.data.model.RecordInfo
import com.example.eatingrecord.databinding.HomeRecordItemBinding
import javax.inject.Inject

class HomeRecordListAdapter @Inject constructor(private val recordDetailListener: TodayRecordDetailListener) : ListAdapter<RecordInfo, HomeRecordListAdapter.ViewHolder>(diffUtil) {

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
        fun bind(item: RecordInfo) {
            binding.textRecommendMenuName.text = item.menuName

            binding.root.setOnClickListener {
                recordDetailListener.onClickRecord(item)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecordInfo>() {
            override fun areItemsTheSame(oldItem: RecordInfo, newItem: RecordInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RecordInfo, newItem: RecordInfo): Boolean {
                return oldItem.menuName == newItem.menuName
            }

        }
    }
}