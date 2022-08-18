package com.example.sesac_week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sesac_week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userList = ArrayList<User>()
    private var userRVAdapter = UserRVAdapter(userList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userItemInit()
        setUpRecyclerView()

        addUser()
    }

    private fun userItemInit() {
        userList.add(User(1, "이름", "010-1111-1111"))
        userList.add(User(2, "이름", "010-1111-1111"))
        userList.add(User(3, "이름", "010-1111-1111"))
        userList.add(User(4, "이름", "010-1111-1111"))
        userList.add(User(5, "이름", "010-1111-1111"))
    }

    private fun setUpRecyclerView(){
        userRVAdapter = UserRVAdapter(userList)
        binding.mainUserRv.adapter = userRVAdapter
        binding.mainUserRv.layoutManager = LinearLayoutManager(this)

        val itemTouchHelperCallback = ItemTouchHelperCallback(userRVAdapter)
        val helper = ItemTouchHelper(itemTouchHelperCallback)
        helper.attachToRecyclerView(binding.mainUserRv)

        addUser()
    }

    private fun addUser(){
        binding.mainAddBtn.setOnClickListener {
            userRVAdapter?.addUserItems(User(userRVAdapter!!.itemCount + 1, "이름", "010-1111-1111"))
        }
    }

}