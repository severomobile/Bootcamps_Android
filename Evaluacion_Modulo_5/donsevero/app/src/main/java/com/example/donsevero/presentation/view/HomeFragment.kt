package com.example.donsevero.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.donsevero.R
import com.example.donsevero.databinding.FragmentHomeBinding
import com.example.donsevero.domain.UseCase
import com.example.donsevero.presentation.viewmodel.TransaccionAdapter
import com.example.donsevero.presentation.viewmodel.TransaccionViewModel
import com.example.donsevero.presentation.viewmodel.UserViewModel
import com.example.donsevero.presentation.viewmodel.ViewModelFactory
import com.example.donsevero.data.repository.transaccion.TransaccionImplement
import com.example.donsevero.data.repository.transaccion.Transacciones
import com.example.donsevero.user.Users
import com.example.donsevero.user.UsersRepositoryImplement

class HomeFragment : Fragment(){

    private lateinit var transaccionAdapter: TransaccionAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usersImplementation = Users()
        val repository = UsersRepositoryImplement(usersImplementation)
        val transaccionesImplementation = Transacciones()
        val repositoryTransaccion = TransaccionImplement(transaccionesImplementation)
        val useCase = UseCase(repository, repositoryTransaccion)
        val viewModelFactory = ViewModelFactory(useCase)

        val userViewModel: UserViewModel by viewModels({ requireActivity() }) { viewModelFactory }

        userViewModel.loadUsersList()
        userViewModel.usersListLD.observe(viewLifecycleOwner){
            Log.i("Home Usuarios", it.toString())
        }

        val transaccionViewModel: TransaccionViewModel by viewModels({ requireActivity() }) {viewModelFactory}


        // Configurar el RecyclerView y el adaptador
        setupRecyclerView()
        //transaccionViewModel.loadTransaccionesList()
        //transaccionViewModel.transaccionesListLD.observe(viewLifecycleOwner) { transacciones ->
            //transaccionAdapter.submitList(transacciones)
        //}

        // Observar los datos del usuario desde el ViewModel compartido
        userViewModel.usuarioAutenticadoLD.observe(viewLifecycleOwner) { usuario ->

            val userId: Int = usuario?.userId!!
            transaccionViewModel.filtrarTransaccionesPorUsuario(userId)

            // Actualizar las vistas con los datos del usuario
            binding.textViewHomeNombre.text = "Hola, ${usuario?.nombre}"
            // Suponiendo que tienes un campo 'nombre' en el objeto User
            binding.textViewHomeSaldo.text = "Saldo: ${usuario?.saldo}"
            // Suponiendo que tienes un campo 'saldo' en el objeto User
        }

        transaccionViewModel.filtroTransaccionesListLD.observe(viewLifecycleOwner) { transacciones ->
            transaccionAdapter.submitList(transacciones)
        }

        // Configurar el clic del botón de enviar dinero
        binding.btnHomeSendMoney.setOnClickListener {
            // Aquí puedes agregar la lógica para enviar dinero
            // Por ejemplo, puedes navegar a otro fragmento para enviar dinero
            navegarAEnviarrDineroFragment()
        }

        // Configurar el clic del botón de depositar dinero
        binding.btnHomeDepositMoney.setOnClickListener {
            // Aquí puedes agregar la lógica para depositar dinero
            // Por ejemplo, puedes navegar a otro fragmento para realizar un depósito
            navegarAIngresarDineroFragment()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        transaccionAdapter = TransaccionAdapter()
        binding.recyclerViewTransacciones.apply {
            adapter = transaccionAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun navegarAIngresarDineroFragment() {
        val ingresarDineroFragment = IngresarDineroFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ingresarDineroFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }

    private fun navegarAEnviarrDineroFragment() {
        val enviarDineroFragment = EnviarDineroFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, enviarDineroFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}