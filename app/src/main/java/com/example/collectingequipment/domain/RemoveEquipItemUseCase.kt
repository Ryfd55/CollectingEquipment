package com.example.collectingequipment.domain

class RemoveEquipItemUseCase(private val equipListRepository: EquipListRepository) {

    fun removeEquipItem(equipItem: EquipItem) {
        equipListRepository.removeEquipItem(equipItem)
    }
}