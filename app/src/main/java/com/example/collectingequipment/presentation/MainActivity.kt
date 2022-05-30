package com.example.collectingequipment.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.collectingequipment.R
import com.example.collectingequipment.domain.EquipItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var llEquipList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llEquipList = findViewById(R.id.ll_equip_list)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.equipList.observe(this) {
            showList(it)
        }
    }

    private fun showList(list: List<EquipItem>) {
        llEquipList.removeAllViews()
        for (equipItem in list) {
            val layoutId = if (equipItem.enabled) {
                R.layout.item_equip_enabled
            } else {
                R.layout.item_equip_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llEquipList, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvName.text = equipItem.name
            tvCount.text = equipItem.count.toString()
            view.setOnLongClickListener {
                viewModel.changeEnableState(equipItem)
                true
            }
            llEquipList.addView(view)
        }
    }
}