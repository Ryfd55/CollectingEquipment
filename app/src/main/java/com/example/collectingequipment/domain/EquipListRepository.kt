package com.example.collectingequipment.domain

import androidx.lifecycle.LiveData

interface EquipListRepository {

    fun  addEquipItem(equipItem: EquipItem)

    fun editEquipItem (equipItem: EquipItem)

    fun getEquipItem(equipItemId: Int): EquipItem

    fun getEquipList(): LiveData<List<EquipItem>>

    fun removeEquipItem(equipItem: EquipItem)
}