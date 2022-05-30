package com.example.collectingequipment.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingequipment.R
import com.example.collectingequipment.domain.EquipItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: EquipListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.equipList.observe(this) {
            adapter.equipList = it
        }
    }

    private  fun  setupRecyclerView() {
        val rvEquipList = findViewById<RecyclerView>(R.id.rv_equip_list)
        adapter = EquipListAdapter()
        rvEquipList.adapter = adapter
    }
}