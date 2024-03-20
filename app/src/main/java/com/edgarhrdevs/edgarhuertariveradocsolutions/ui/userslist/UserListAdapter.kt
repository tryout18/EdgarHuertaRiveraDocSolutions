package com.edgarhrdevs.edgarhuertariveradocsolutions.ui.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edgarhrdevs.edgarhuertariveradocsolutions.databinding.UserItemBinding
import com.edgarhrdevs.edgarhuertariveradocsolutions.domain.UserResponseBody

class UserListAdapter : ListAdapter<UserResponseBody, UserListAdapter.ViewHolder>(UserListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: UserResponseBody
        ){
            binding.user = item
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}

class UserListDiffCallback: DiffUtil.ItemCallback<UserResponseBody>(){
    override fun areItemsTheSame(oldItem: UserResponseBody, newItem: UserResponseBody): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: UserResponseBody, newItem: UserResponseBody): Boolean {
        return oldItem == newItem
    }

}