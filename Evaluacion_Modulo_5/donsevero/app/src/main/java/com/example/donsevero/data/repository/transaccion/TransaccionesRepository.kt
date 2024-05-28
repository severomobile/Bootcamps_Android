package com.example.donsevero.data.repository.transaccion

import com.example.donsevero.data.model.Transaccion


/**
 * Interfaz que define las operaciones para gestionar las transacciones en el repositorio.
 */
interface TransaccionesRepository {

    /**
     * Recupera todas las transacciones del repositorio.
     *
     * @return Una lista mutable de todas las transacciones.
     */
    suspend fun fetchTransacciones(): MutableList<Transaccion>

    /**
     * Agrega una nueva transacción al repositorio.
     *
     * @param newTransaccion La nueva transacción a agregar.
     * @return La transacción agregada.
     */
    suspend fun addTransaccion(newTransaccion: Transaccion): Transaccion
}
