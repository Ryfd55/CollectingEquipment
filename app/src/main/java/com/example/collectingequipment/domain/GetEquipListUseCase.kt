package com.example.collectingequipment.domain

class GetEquipListUseCase(private val equipListRepository: EquipListRepository) {

    fun getEquipList(): List<EquipItem> {
        return equipListRepository.getEquipList()
    }
}