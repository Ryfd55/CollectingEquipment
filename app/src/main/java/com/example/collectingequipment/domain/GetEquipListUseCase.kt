package com.example.collectingequipment.domain

import androidx.lifecycle.LiveData

class GetEquipListUseCase(private val equipListRepository: EquipListRepository) {

    fun getEquipList(): LiveData<List<EquipItem>> {
        return equipListRepository.getEquipList()
    }
}