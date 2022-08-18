package com.example.sesac_week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sesac_week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var userRVAdapter: UserRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        addUser()
    }

    private fun setUpRecyclerView(){
        binding.mainUserRv.apply {
            userRVAdapter = UserRVAdapter()
            adapter = userRVAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        addUser()
    }

    private fun addUser(){
        binding.mainAddBtn.setOnClickListener {
            userRVAdapter?.addUserItems(User(userRVAdapter!!.itemCount, "바보", "010-1111-1111"))
        }
    }

}