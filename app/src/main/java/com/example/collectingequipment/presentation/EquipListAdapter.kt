package com.example.collectingequipment.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.collectingequipment.R
import com.example.collectingequipment.domain.EquipItem
import android.view.View
import androidx.core.content.ContextCompat

class EquipListAdapter : RecyclerView.Adapter<EquipListAdapter.EquipItemViewHolder>() {

    var equipList = listOf<EquipItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_equip_disabled,
            parent,
            false
        )
        return EquipItemViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: EquipItemViewHolder, position: Int) {
        val equipItem = equipList[position]
        val status = if (equipItem.enabled) {
            "Active"
        } else {
            "Not active"
        }

        viewholder.view.setOnLongClickListener {
            true
        }
        if (equipItem.enabled) {
            viewholder.tvName.text = "${equipItem.name} $status"
            viewholder.tvCount.text = equipItem.count.toString()
            viewholder.tvName.setTextColor(
                ContextCompat.getColor(
                    viewholder.view.context,
                    android.R.color.holo_red_light
                )
            )
        }
    }

    override fun onViewRecycled(viewholder: EquipItemViewHolder) {
        super.onViewRecycled(viewholder)
        viewholder.tvName.text = ""
        viewholder.tvCount.text = ""
        viewholder.tvName.setTextColor(ContextCompat.getColor(viewholder.view.context,
            android.R.color.white))
    }

    override fun getItemCount(): Int {
        return equipList.size
    }

    class EquipItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
}