package com.example.donsevero.user

import com.example.donsevero.data.model.User
import com.example.donsevero.user.Users
import com.example.donsevero.user.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersRepositoryImplement(users: Users) : UsersRepository {

    private val userList: MutableList<User> = users.getAllUsers()

    override suspend fun fetchUsers(): MutableList<User> {
        return withContext(Dispatchers.IO){
            userList
        }
    }

    override suspend fun addUser(newUser: User): User {

        return withContext(Dispatchers.IO){
            // Aquí podrías agregar el nuevo usuario a la lista y luego devolverlo
            userList.add(newUser)
            newUser
        }
    }

    override suspend fun getUserById(userId: Int): User? {
        return withContext(Dispatchers.IO){
            // Buscar el usuario por su ID en la lista
            userList.find { it.userId == userId }
        }
    }

    override suspend fun updateUser(updatedUser: User) {
        return withContext(Dispatchers.IO) {
            // Actualizar el usuario en la lista
            val index = userList.indexOfFirst { it.userId == updatedUser.userId }
            if (index != -1) {
                userList[index] = updatedUser
            }
        }
    }
}