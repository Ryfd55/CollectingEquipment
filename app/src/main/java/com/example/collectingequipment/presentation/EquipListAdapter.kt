package com.example.collectingequipment.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingequipment.R
import com.example.collectingequipment.domain.EquipItem
import android.view.View

class EquipListAdapter : RecyclerView.Adapter<EquipListAdapter.EquipItemViewHolder>() {

    val list = listOf<EquipItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate((R.layout.item_equip_disabled, parent,false))
         return EquipItemViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: EquipItemViewHolder, position: Int) {
        val equipItem = list[position]
        viewholder.tvName.text = equipItem.name
        viewholder.tvCount.text = equipItem.count.toString()
        viewholder.view.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class EquipItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
}