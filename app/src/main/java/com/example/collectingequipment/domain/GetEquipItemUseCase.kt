package com.example.collectingequipment.domain

class GetEquipItemUseCase(private val equipListRepository: EquipListRepository) {

    fun getEquipItem(equipItemId: Int): EquipItem {
        return equipListRepository.getEquipItem(equipItemId)
    }
}