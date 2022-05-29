package com.example.collectingequipment.domain

class EditEquipItemUseCase(private val equipListRepository: EquipListRepository) {

    fun editEquipItem(equipItem: EquipItem) {
        equipListRepository.editEquipItem(equipItem)
    }
}