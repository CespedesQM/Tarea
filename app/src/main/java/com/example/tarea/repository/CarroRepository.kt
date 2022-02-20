package com.example.tarea.repository

import androidx.lifecycle.LiveData
import com.example.tarea.data.CarroDao
import com.example.tarea.model.Carro

class CarroRepository(private val carroDao: CarroDao) {
    val getAllData: LiveData<List<Carro>> = carroDao.getAllData()

    suspend fun addCarro(carro: Carro){
        carroDao.addCarro(carro)
    }
    suspend fun updateCarro(carro:Carro){
        carroDao.updateCarro(carro)
    }
    suspend fun deleteCarro(carro:Carro){
        carroDao.deleteCarro(carro)
    }
}