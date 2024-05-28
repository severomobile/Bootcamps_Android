package com.example.donsevero.data.model

/**
 * Clase que representa un usuario en el sistema.
 *
 * @property userId El ID único del usuario. Por defecto, es -1 si no se proporciona.
 * @property nombre El nombre del usuario.
 * @property apellido El apellido del usuario.
 * @property correo El correo electrónico del usuario.
 * @property contrasena La contraseña del usuario.
 * @property saldo El saldo del usuario. Por defecto, es 0.0 si no se proporciona.
 */
data class User(
    val userId: Int = -1,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val contrasena: String,
    var saldo: Double = 0.0
)

