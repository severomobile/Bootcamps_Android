package com.example.donsevero.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donsevero.domain.UseCase
import com.example.donsevero.data.model.Transaccion
import kotlinx.coroutines.launch


class TransaccionViewModel(private val useCase: UseCase) : ViewModel() {

    private val transaccionesList = MutableLiveData<MutableList<Transaccion>>()

    val transaccionesListLD: LiveData<MutableList<Transaccion>>
        get() = transaccionesList

    fun loadTransaccionesList(){
        viewModelScope.launch{
            val transacciones = useCase.getAllTransacciones()
            transaccionesList.postValue(transacciones)
        }
    }

    private val nuevaTransaccion = MutableLiveData<Transaccion>()

    val nuevaTransaccionLD: LiveData<Transaccion>
        get() = nuevaTransaccion

    fun loadNuevaTransaccion(newTransaccion: Transaccion){
        viewModelScope.launch {
            val transaccion = useCase.createNewTransaccion(newTransaccion)
            nuevaTransaccion.postValue(transaccion)
        }
    }

    private val filtroTransaccionesList = MutableLiveData<MutableList<Transaccion>>()

    val filtroTransaccionesListLD: LiveData<MutableList<Transaccion>>
        get() = filtroTransaccionesList

    fun filtrarTransaccionesPorUsuario(userId: Int) {
        viewModelScope.launch {
            val transaccionesFiltradas = useCase.filtrarTransaccionPorUsuario(userId)
            filtroTransaccionesList.postValue(transaccionesFiltradas)
        }
    }
}