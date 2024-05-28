package com.example.donsevero.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.donsevero.domain.UseCase

class ViewModelFactory(private val useCase: UseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserViewModel::class.java) -> {
                UserViewModel(useCase) as T
            }
            modelClass.isAssignableFrom(TransaccionViewModel::class.java) -> {
                TransaccionViewModel(useCase) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}