package com.example.sesac_week3

// RecyclerView의 Adapter와 ItemTouchHelper.Callback을 연결시켜 주는 리스너
interface ItemTouchHelperListener {
    fun onItemMove(from_position: Int, to_position: Int): Boolean
    fun onItemSwipe(position: Int)
}