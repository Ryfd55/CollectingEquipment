package com.example.collectingequipment.domain

interface EquipListRepository {

    fun  addEquipItem(equipItem: EquipItem)

    fun editEquipItem (equipItem: EquipItem)

    fun getEquipItem(equipItemId: Int): EquipItem

    fun getEquipList(): List<EquipItem>

    fun removeEquipItem(equipItem: EquipItem)
}