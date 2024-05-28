package com.example.donsevero.presentation.view

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.donsevero.databinding.FragmentEnviarDineroBinding
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

class EnviarDineroFragment : Fragment() {

    private var _binding: FragmentEnviarDineroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnviarDineroBinding.inflate(inflater, container, false)
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

        userViewModel.loadUsersList()

        // Observar los datos del usuario desde el ViewModel compartido
        userViewModel.usuarioAutenticadoLD.observe(viewLifecycleOwner) { usuario ->


            // Mostrar el nombre del usuario en la interfaz de usuario
            binding.textViewEnviarDineroNombreUsuario.text = "Nombre: ${usuario?.nombre}"

            // Observar la lista de usuarios
            userViewModel.usersListLD.observe(viewLifecycleOwner) { listaUsuarios ->

                // Filtrar la lista de usuarios para excluir al usuario actual
                val listaFiltrada = listaUsuarios.filter { it.userId != usuario?.userId }

                // Crear un adaptador para el Spinner con la lista de usuarios filtrada
                val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item,
                    listaFiltrada.map { it.nombre })
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

                // Establecer el adaptador en el Spinner
                binding.spinnerEnviarDineroUsuarios.adapter = adapter
            }
        }

        // Configurar el clic del botón de enviar dinero
        binding.btnEnviarDinero.setOnClickListener {
            userViewModel.usuarioAutenticadoLD.observe(viewLifecycleOwner) { usuario ->

                val monto = binding.editTextEnviarDineroMontoEnviar.text.toString().toLongOrNull()

                if (monto != null && usuario?.saldo!! >=  monto) {

                    // Obtener el usuario seleccionado del Spinner
                    val usuarioSeleccionadoPosition =
                        binding.spinnerEnviarDineroUsuarios.selectedItemPosition

                    // Observar los usuarios desde el ViewModel compartido
                    userViewModel.usersListLD.observe(viewLifecycleOwner) { listaUsuarios ->


                        // Filtrar la lista de usuarios para excluir al usuario actual
                        val listaFiltrada = listaUsuarios
                            .filter { it.userId != userViewModel.usuarioAutenticadoLD.value?.userId }

                        // Verificar si la posición seleccionada es válida
                        if (usuarioSeleccionadoPosition in listaFiltrada.indices) {
                            // Obtener el usuario seleccionado
                            val usuarioSeleccionado = listaFiltrada[usuarioSeleccionadoPosition]

                            // Extraer el ID del usuario seleccionado
                            val idUsuarioSeleccionado = usuarioSeleccionado.userId


                            // Enviar el dinero llamando al método correspondiente en el ViewModel

                            viewLifecycleOwner.lifecycleScope.launch {
                                val userId: Int = usuario?.userId!!

                                transaccionViewModel.loadNuevaTransaccion(
                                    Transaccion(
                                        IdGenerator.generateUniqueId(),
                                        userId,
                                        idUsuarioSeleccionado,
                                        monto,
                                        Date()
                                    )
                                )

                                userViewModel.restarSaldoUsuario(userId, monto)

                                // Mostrar un Toast de éxito
                                Toast.makeText(
                                    requireContext(), "Envío de dinero exitoso", Toast.LENGTH_SHORT
                                ).show()

                                navegarAHomeFragment()
                            }
                        } else {
                            // Mostrar un mensaje de error si no se seleccionó ningún usuario
                            Toast.makeText(
                                requireContext(),
                                "Por favor seleccione un usuario",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    // Mostrar un mensaje de error si el monto ingresado no es válido
                    Toast.makeText(
                        requireContext()
                        , "Monto no valido o supera el saldo de su cuenta", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navegarAHomeFragment() {
        val homeFragment = HomeFragment()
        parentFragmentManager.beginTransaction()
            .replace(com.example.donsevero.R.id.fragment_container, homeFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}