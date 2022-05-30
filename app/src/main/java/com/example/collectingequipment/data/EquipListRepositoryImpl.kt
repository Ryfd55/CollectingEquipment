package com.example.collectingequipment.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.collectingequipment.domain.EquipItem
import com.example.collectingequipment.domain.EquipListRepository

object EquipListRepositoryImpl: EquipListRepository {

    private val equipListLD = MutableLiveData<List<EquipItem>>()
    private val equipList = sortedSetOf<EquipItem>({ o1, o2 -> o1.id.compareTo(o2.id)})

    private var autoIncrementId = 0

    init {
        for (i in 0 until 100) {
            val item = EquipItem("Name $i",i, true)
            addEquipItem(item)
        }
    }

    override fun addEquipItem(equipItem: EquipItem) {
        if (equipItem.id == EquipItem.UNDEFINED_ID) {
            equipItem.id = autoIncrementId++
        }
        equipList.add(equipItem)
        updateList()
    }

    override fun editEquipItem(equipItem: EquipItem) {
        val oldElement = getEquipItem(equipItem.id)
        equipList.remove(oldElement)
        addEquipItem(equipItem)
    }

    override fun getEquipItem(equipItemId: Int): EquipItem {
        return equipList.find {
            it.id == equipItemId
        } ?: throw RuntimeException ("Element with id $equipItemId not found")
    }

    override fun getEquipList(): LiveData<List<EquipItem>> {
        return equipListLD
    }

    override fun removeEquipItem(equipItem: EquipItem) {
        equipList.remove(equipItem)
        updateList()
    }
    private  fun updateList() {
        equipListLD.value = equipList.toList()
    }
}