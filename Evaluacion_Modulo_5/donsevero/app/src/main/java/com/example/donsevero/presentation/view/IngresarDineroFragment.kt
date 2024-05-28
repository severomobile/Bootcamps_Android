package com.example.donsevero.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.donsevero.R
import com.example.donsevero.databinding.FragmentIngresarDineroBinding
import com.example.donsevero.domain.UseCase
import com.example.donsevero.data.model.Transaccion
import com.example.donsevero.objectUtil.IdGenerator
import com.example.donsevero.presentation.viewmodel.TransaccionViewModel
import com.example.donsevero.presentation.viewmodel.UserViewModel
import com.example.donsevero.presentation.viewmodel.ViewModelFactory
import com.example.donsevero.data.repository.transaccion.TransaccionImplement
import com.example.donsevero.data.repository.transaccion.Transacciones
import com.example.donsevero.user.Users
import com.example.donsevero.user.UsersRepositoryImplement
import kotlinx.coroutines.launch
import java.util.Date

class IngresarDineroFragment : Fragment() {

    private var _binding: FragmentIngresarDineroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIngresarDineroBinding.inflate(inflater, container, false)
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

        val transaccionViewModel: TransaccionViewModel by viewModels({ requireActivity() }) {viewModelFactory}

        transaccionViewModel.loadTransaccionesList()

        // Observar los datos del usuario desde el ViewModel compartido
        userViewModel.usuarioAutenticadoLD.observe(viewLifecycleOwner) { usuario ->

            // Actualizar las vistas con los datos del usuario
            binding.textViewIngresarDineroNombre.text = "Hola, ${usuario?.nombre}"
            // Suponiendo que tienes un campo 'nombre' en el objeto User
            binding.textViewIngresarDineroCorreo.text = "Correo: ${usuario?.correo}"
            // Suponiendo que tienes un campo 'saldo' en el objeto User
        }

        // Configurar el clic del botón de ingresar dinero
        binding.btnIngresarDineroIngresarDinero.setOnClickListener {

            userViewModel.usuarioAutenticadoLD.observe(viewLifecycleOwner) { usuario ->

                val monto = binding.editTextIngresarDineroMontoIngresar.text.toString().toLongOrNull()

                val userId: Int = usuario?.userId!!

                if (monto != null) {

                    viewLifecycleOwner.lifecycleScope.launch {
                        // Ingresar el dinero llamando al método correspondiente en el ViewModel
                        transaccionViewModel.loadNuevaTransaccion(
                            Transaccion(
                                IdGenerator.generateUniqueId(),
                                userId,
                                userId,
                                monto,
                                Date()
                            )
                        )

                        // Mostrar un Toast de éxito
                        Toast.makeText(
                            requireContext(), "Ingreso de dinero exitoso", Toast.LENGTH_SHORT
                        ).show()

                        userViewModel.actualizarSaldoUsuario(userId, monto)
                    }
                } else {
                    // Mostrar un mensaje de error si el monto ingresado no es válido
                    // (por ejemplo, si no se ingresó un número válido)
                    // Puedes manejar este caso según tus necesidades específicas
                    // Por ejemplo, mostrar un mensaje Toast indicando que el monto es inválido

                    Toast.makeText(
                        requireContext(), "Por favor ingrese un monto válido", Toast.LENGTH_SHORT
                    ).show()
                }
            }
            navegarAHomeFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navegarAHomeFragment() {
        val homeFragment = HomeFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}