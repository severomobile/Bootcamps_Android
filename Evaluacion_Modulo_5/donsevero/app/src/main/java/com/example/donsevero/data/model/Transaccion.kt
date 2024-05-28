package com.example.donsevero.data.model

import java.util.Date

/**
 * Clase que representa una transacción realizada entre dos usuarios.
 *
 * @property transactionId El ID único de la transacción.
 * @property remitenteId El ID del usuario que realizó la transacción.
 * @property destinatarioId El ID del usuario que recibió la transacción.
 * @property amount El monto de la transacción.
 * @property timestamp La fecha y hora en que se realizó la transacción. Por defecto, es la fecha y hora actual.
 */
data class Transaccion(
    val transactionId: Int = -1,
    val remitenteId: Int,
    val destinatarioId: Int,
    val amount: Long,
    val timestamp: Date = Date()
)