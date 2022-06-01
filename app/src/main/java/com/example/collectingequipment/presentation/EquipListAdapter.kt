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

    var count = 0
    var equipList = listOf<EquipItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_DISABLED -> R.layout.item_equip_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_equip_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return EquipItemViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: EquipItemViewHolder, position: Int) {
        val equipItem = equipList[position]
        viewholder.view.setOnLongClickListener {
            true
        }
        viewholder.tvName.text = equipItem.name
        viewholder.tvCount.text = equipItem.count.toString()
    }

    override fun onViewRecycled(viewholder: EquipItemViewHolder) {
        super.onViewRecycled(viewholder)
        viewholder.tvName.text = ""
        viewholder.tvCount.text = ""
        viewholder.tvName.setTextColor(
            ContextCompat.getColor(
                viewholder.view.context,
                android.R.color.white
            )
        )
    }

    override fun getItemCount(): Int {
        return equipList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = equipList[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    class EquipItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
    }

}