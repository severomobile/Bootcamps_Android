package com.example.donsevero.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donsevero.data.model.User
import com.example.donsevero.domain.UseCase
import kotlinx.coroutines.launch

class UserViewModel(private val useCase: UseCase) : ViewModel() {

    private var usersList = MutableLiveData<MutableList<User>>()

    val usersListLD: LiveData<MutableList<User>>
        get() = usersList

    fun loadUsersList() {
        viewModelScope.launch {
            val users = useCase.getAllUsers()
            usersList.postValue(users)
        }
    }

    private val addUser = MutableLiveData<User>()

    val newUserLD: LiveData<User>
        get() = addUser

    fun loadAddUser(newUser: User) {
        viewModelScope.launch {
          val usuario = useCase.createNewUser(newUser)
          addUser.postValue(usuario)
        }
    }

    private val usuarioAutenticado = MutableLiveData<User?>()

    val usuarioAutenticadoLD: LiveData<User?>
        get() = usuarioAutenticado

    suspend fun iniciarSesion(correo: String, contraseña: String): Boolean {
        val usuarioAutenticado = useCase.validarCredenciales(correo, contraseña)
        val autenticado = usuarioAutenticado != null
        this.usuarioAutenticado.postValue(usuarioAutenticado)
        return autenticado
    }

    suspend fun actualizarSaldoUsuario(userId: Int, monto: Long): User? {
        return useCase.actualizarSaldoUsuario(userId, monto)
    }

    suspend fun restarSaldoUsuario(userId: Int, monto: Long): User? {
        return useCase.restarSaldoUsuario(userId, monto)
    }
}
