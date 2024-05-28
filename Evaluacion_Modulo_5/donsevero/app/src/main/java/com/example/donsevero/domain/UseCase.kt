package com.example.donsevero.domain

import com.example.donsevero.data.model.Transaccion
import com.example.donsevero.data.model.User
import com.example.donsevero.data.repository.transaccion.TransaccionImplement
import com.example.donsevero.user.UsersRepositoryImplement

class UseCase(private val repository: UsersRepositoryImplement
, private val repositoryTransaccion: TransaccionImplement
) {

    suspend fun getAllUsers(): MutableList<User>{
        return repository.fetchUsers()
    }

    suspend fun createNewUser(newUser: User): User {
        return repository.addUser(newUser)
    }

    suspend fun getAllTransacciones(): MutableList<Transaccion>{
        return repositoryTransaccion.fetchTransacciones()
    }

    suspend fun createNewTransaccion(newTransaccion: Transaccion): Transaccion {
        return repositoryTransaccion.addTransaccion((newTransaccion))
    }

    // Método para validar las credenciales del usuario
    suspend fun validarCredenciales(correo: String, contraseña: String): User? {
        return getAllUsers().find {
            it.correo == correo && it.contrasena == contraseña }
    }

    //Metodo para filtrar lista de transacciones
    suspend fun filtrarTransaccionPorUsuario(userId: Int): MutableList<Transaccion> {
        return getAllTransacciones().filter {
            it.remitenteId == userId || it.destinatarioId == userId }
            .toMutableList()
    }

    suspend fun actualizarSaldoUsuario(userId: Int, monto: Long): User? {
        val usuario = repository.getUserById(userId)
        if (usuario != null) {
            usuario.saldo += monto
            repository.updateUser(usuario)
        }
        return usuario
    }

    suspend fun restarSaldoUsuario(userId: Int, monto: Long): User? {
        val usuario = repository.getUserById(userId)
        if (usuario != null) {
            usuario.saldo -= monto
            repository.updateUser(usuario)
        }
        return usuario
    }
}