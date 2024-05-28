package com.example.donsevero.objectUtil

/**
 * El objeto `IdGenerator` se utiliza para generar identificadores únicos.
 */
object IdGenerator {
    private var userIdCounter = 1 // Inicializar el contador en 1

    /**
     * Genera un identificador único.
     *
     * @return El identificador único generado.
     */
    fun generateUniqueId(): Int {
        return userIdCounter++
    }
}

