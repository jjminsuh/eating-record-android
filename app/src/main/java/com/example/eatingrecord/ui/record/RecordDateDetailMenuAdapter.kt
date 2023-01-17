package com.example.eatingrecord.ui.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eatingrecord.data.model.RecordInfo
import com.example.eatingrecord.databinding.RecordListItemBinding
import javax.inject.Inject

class RecordDateDetailMenuAdapter @Inject constructor() : ListAdapter<RecordInfo, RecordDateDetailMenuAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecordListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ViewHolder(private val binding: RecordListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecordInfo) {
            binding.textMenuName.text = item.menuName
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecordInfo>() {
            override fun areItemsTheSame(oldItem: RecordInfo, newItem: RecordInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RecordInfo, newItem: RecordInfo): Boolean {
                return oldItem.menuId == newItem.menuId
            }
        }
    }
}