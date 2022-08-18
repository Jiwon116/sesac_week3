package com.example.sesac_week3

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sesac_week3.databinding.ItemUserBinding

class UserRVAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val userItems = arrayListOf<User>()
    private val checkboxStatus = SparseBooleanArray()

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userItem: User) = with(binding){
            itemUserId.text = userItem.userId.toString()
            itemUserName.text = userItem.userName
            itemUserPhone.text = userItem.userPhone

            itemUserCheckBtn.isChecked = checkboxStatus[adapterPosition]

            itemUserCheckBtn.setOnClickListener {
                if (!itemUserCheckBtn.isChecked)
                    checkboxStatus.put(adapterPosition, false)
                else
                    checkboxStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }
        }
    }

    fun addUserItems(user: User){
        userItems.add(user)
        notifyItemInserted(userItems.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerView.ViewHolder = UserViewHolder (
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder)
            holder.bind(userItems[position])
    }

    override fun getItemCount(): Int = if (userItems.isEmpty()) 0 else userItems.size
}