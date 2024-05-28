package com.example.donsevero.user

import com.example.donsevero.data.model.User

/**
 * La interfaz `UsersRepository` define las operaciones disponibles para interactuar con los usuarios en el repositorio.
 * Proporciona métodos para obtener, agregar, actualizar y buscar usuarios.
 */
interface UsersRepository {

    /**
     * Obtiene todos los usuarios del repositorio.
     *
     * @return Una lista mutable de todos los usuarios.
     */
    suspend fun fetchUsers(): MutableList<User>

    /**
     * Agrega un nuevo usuario al repositorio.
     *
     * @param newUser El nuevo usuario que se va a agregar.
     * @return El usuario agregado.
     */
    suspend fun addUser(newUser: User): User

    /**
     * Obtiene un usuario por su ID del repositorio.
     *
     * @param userId El ID del usuario que se va a buscar.
     * @return El usuario encontrado o nulo si no se encuentra.
     */
    suspend fun getUserById(userId: Int): User?

    /**
     * Actualiza la información de un usuario en el repositorio.
     *
     * @param updatedUser El usuario con la información actualizada.
     */
    suspend fun updateUser(updatedUser: User)
}

