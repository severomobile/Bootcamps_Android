package com.example.donsevero.user

import com.example.donsevero.data.model.User
import com.example.donsevero.objectUtil.IdGenerator.generateUniqueId

/**
 * La clase `Users` representa un repositorio de usuarios predefinidos.
 * Proporciona una lista de usuarios predefinidos para uso en la aplicación.
 */
class Users {
    // Lista de usuarios predefinidos
    private val listaDeUsuarios: MutableList<User> = mutableListOf(
        User(generateUniqueId(), "Juan", "Pérez"
            , "hola", "hola", 100.0),
        User(generateUniqueId(), "María", "Gómez"
            , "maria@example.com", "clave456", 50.0),
        User(generateUniqueId(), "Carlos", "Martínez"
            , "carlos@example.com", "pass789", 200.0),
        User(generateUniqueId(), "Ana", "López"
            , "ana@example.com", "secreto321", 150.0),
        User(generateUniqueId(), "Pedro", "Sánchez"
            , "pedro@example.com", "seguridad789", 75.0)
    )

    /**
     * Obtiene todos los usuarios predefinidos.
     *
     * @return Una lista mutable de todos los usuarios predefinidos.
     */
    fun getAllUsers(): MutableList<User> {
        return listaDeUsuarios
    }
}

