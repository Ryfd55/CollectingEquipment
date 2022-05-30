package com.example.collectingequipment.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collectingequipment.data.EquipListRepositoryImpl
import com.example.collectingequipment.domain.EditEquipItemUseCase
import com.example.collectingequipment.domain.EquipItem
import com.example.collectingequipment.domain.GetEquipListUseCase
import com.example.collectingequipment.domain.RemoveEquipItemUseCase

class MainViewModel : ViewModel() {

    private val repository = EquipListRepositoryImpl

    private val getEquipListUseCase = GetEquipListUseCase(repository)
    private val removeEquipItemUseCase = RemoveEquipItemUseCase(repository)
    private val editEquipItemUseCase = EditEquipItemUseCase(repository)

    val equipList = getEquipListUseCase.getEquipList()

    fun removeEquipItem(equipItem: EquipItem) {
        removeEquipItemUseCase.removeEquipItem(equipItem)
    }

    fun changeEnableState(equipItem: EquipItem) {
        val newItem = equipItem.copy(enabled = !equipItem.enabled)
        editEquipItemUseCase.editEquipItem(newItem)
    }
}