package com.example.donsevero.presentation.viewmodel

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donsevero.R
import com.example.donsevero.data.model.Transaccion
import java.util.Locale

class TransaccionAdapter : ListAdapter<Transaccion
        , TransaccionAdapter.TransaccionViewHolder>(TransaccionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaccionViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_item_transaccion, parent, false)
        return TransaccionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransaccionViewHolder, position: Int) {
        val transaccion = getItem(position)
        holder.bind(transaccion)
    }

    class TransaccionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idTransaccionTextView: TextView = itemView
            .findViewById(R.id.textViewTransactionId)

        private val remitenteTextView: TextView = itemView
            .findViewById(R.id.textViewRemitenteId)

        private val destinatarioTextView: TextView = itemView
            .findViewById(R.id.textViewDestinatarioId)

        private val amountTextView: TextView = itemView
            .findViewById(R.id.textViewAmount)

        private val timestampTextView: TextView = itemView
            .findViewById(R.id.textViewTimestamp)

        fun bind(transaccion: Transaccion) {
            idTransaccionTextView.text = "Transaccion ID: ${transaccion.transactionId}"
            remitenteTextView.text = "Remitente: ${transaccion.remitenteId}"
            destinatarioTextView.text = "Destinatario: ${transaccion.destinatarioId}"
            amountTextView.text = "Amount: ${transaccion.amount}"

            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            timestampTextView.text = "Timestamp: ${formatter.format(transaccion.timestamp)}"
        }
    }

    private class TransaccionDiffCallback : DiffUtil.ItemCallback<Transaccion>() {
        override fun areItemsTheSame(oldItem: Transaccion, newItem: Transaccion): Boolean {
            return oldItem.transactionId == newItem.transactionId
        }

        override fun areContentsTheSame(oldItem: Transaccion, newItem: Transaccion): Boolean {
            return oldItem == newItem
        }
    }
}