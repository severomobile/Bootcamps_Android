package com.example.donsevero.data.repository.transaccion

import com.example.donsevero.data.model.Transaccion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class TransaccionImplement(transacciones : Transacciones) : TransaccionesRepository {

    private val transaccionList: MutableList<Transaccion> = transacciones.getAllTransacciones()

    override suspend fun fetchTransacciones(): MutableList<Transaccion> {
        return withContext(Dispatchers.IO){
            transaccionList
        }
    }

    override suspend fun addTransaccion(newTransaccion: Transaccion): Transaccion {
        return withContext(Dispatchers.IO){
            transaccionList.add(newTransaccion)
            newTransaccion
        }
    }
}