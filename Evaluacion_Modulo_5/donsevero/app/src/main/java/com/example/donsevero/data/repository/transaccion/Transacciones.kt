package com.example.donsevero.data.repository.transaccion

import com.example.donsevero.data.model.Transaccion
import com.example.donsevero.objectUtil.IdGenerator.generateUniqueId
import java.util.Date

/**
 * Clase que gestiona las transacciones en el sistema.
 */
class Transacciones {

    // Lista mutable que almacena todas las transacciones
    private val listaDeTransacciones: MutableList<Transaccion> = mutableListOf(
        Transaccion(generateUniqueId(), 1, 2, 500, Date()),
        Transaccion(generateUniqueId(), 3, 4, 300, Date()),
        Transaccion(generateUniqueId(), 2, 1, 200, Date()),
        Transaccion(generateUniqueId(), 1, 3, 1000, Date()),
        Transaccion(generateUniqueId(), 4, 2, 750, Date()),
        Transaccion(generateUniqueId(), 2, 3, 400, Date()),
        Transaccion(generateUniqueId(), 3, 1, 600, Date()),
        Transaccion(generateUniqueId(), 4, 1, 900, Date()),
        Transaccion(generateUniqueId(), 2, 4, 150, Date()),
        Transaccion(generateUniqueId(), 1, 4, 800, Date())
    )

    /**
     * Retorna una lista mutable de todas las transacciones.
     *
     * @return La lista de todas las transacciones.
     */
    fun getAllTransacciones(): MutableList<Transaccion> {
        return listaDeTransacciones
    }
}
