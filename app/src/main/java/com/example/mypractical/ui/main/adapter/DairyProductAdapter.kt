package com.example.mypractical.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypractical.BR
import com.example.mypractical.data.model.UserListModel
import com.example.mypractical.databinding.AdapterUserListBinding
import com.example.mypractical.ui.main.MainActivity
import com.example.mypractical.utils.LogM

class DairyProductAdapter(private val listner: MainActivity)
    : PagingDataAdapter<UserListModel.Data1, DairyProductAdapter.MyViewHolder>(DiffUtil) {
    companion object {
        val DiffUtil = object : DiffUtil.ItemCallback<UserListModel.Data1>() {
            override fun areItemsTheSame(
                oldItem: UserListModel.Data1,
                newItem: UserListModel.Data1
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UserListModel.Data1,
                newItem: UserListModel.Data1
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MyViewHolder(val adapteDairyProductBidning: AdapterUserListBinding): RecyclerView.ViewHolder(adapteDairyProductBidning.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.adapteDairyProductBidning.setVariable(BR.userList,getItem(position))
        holder.adapteDairyProductBidning.setVariable(BR.listner, listner )
        holder.adapteDairyProductBidning.setVariable(BR.position, position + 1)
        holder.adapteDairyProductBidning.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = AdapterUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

}