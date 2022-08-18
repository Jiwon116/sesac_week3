package com.example.sesac_week3

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sesac_week3.databinding.ItemUserBinding
import java.util.*
import kotlin.collections.ArrayList

class UserRVAdapter(private val userItems: ArrayList<User>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperListener {

    private val checkboxStatus = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder = UserViewHolder (
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder)
            holder.bind(userItems[position])
    }

    override fun getItemCount(): Int = if (userItems.isEmpty()) 0 else userItems.size

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

    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        val name = userItems[from_position]
        // 리스트 갱신
        userItems.removeAt(from_position)
        userItems.add(to_position, name)

        // fromPosition에서 toPosition으로 아이템 이동 공지
        notifyItemMoved(from_position, to_position)
        return true
    }

    override fun onItemSwipe(position: Int) {
        // 리스트 아이템 삭제
        userItems.removeAt(position)
        // 아이템 삭제되었다고 공지
        notifyItemRemoved(position)
    }
}