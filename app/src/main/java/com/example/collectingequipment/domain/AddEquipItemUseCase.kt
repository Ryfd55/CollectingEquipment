package com.example.collectingequipment.domain

class AddEquipItemUseCase (private val equipListRepository: EquipListRepository){

    fun addEquipItem(equipItem: EquipItem) {
        equipListRepository.addEquipItem(equipItem)
    }
}