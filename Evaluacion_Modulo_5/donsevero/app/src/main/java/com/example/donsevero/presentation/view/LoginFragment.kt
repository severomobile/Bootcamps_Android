package com.example.donsevero.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.donsevero.R
import com.example.donsevero.databinding.FragmentLoginBinding
import com.example.donsevero.databinding.FragmentRegisterBinding
import com.example.donsevero.domain.UseCase
import com.example.donsevero.presentation.viewmodel.TransaccionViewModel
import com.example.donsevero.presentation.viewmodel.UserViewModel
import com.example.donsevero.presentation.viewmodel.ViewModelFactory
import com.example.donsevero.data.repository.transaccion.TransaccionImplement
import com.example.donsevero.data.repository.transaccion.Transacciones
import com.example.donsevero.user.Users
import com.example.donsevero.user.UsersRepositoryImplement
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
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
            Log.i("Login Usuarios", it.toString())
        }

        val transaccionViewModel: TransaccionViewModel by viewModels({ requireActivity() }) {viewModelFactory}


        binding.btnLoginIniciarSesion.setOnClickListener {
            // Obtener los datos del formulario
            val correo = binding.editTextLoginCorreo.text.toString()
            val contraseña = binding.editTextLoginContraseA.text.toString()

            // Verificar si los campos están completos
            if (correo.isNotEmpty() && contraseña.isNotEmpty()) {

                viewLifecycleOwner.lifecycleScope.launch {

                    // Iniciar sesión
                    val autenticado = userViewModel.iniciarSesion(correo, contraseña)

                    if (autenticado) {
                        // Mostrar un mensaje de éxito si la autenticación es exitosa
                        Toast.makeText(requireContext(), "Inicio de sesión exitoso"
                            , Toast.LENGTH_SHORT).show()

                        navegarAHomeFragment()

                    } else {
                        // Mostrar un mensaje de error si la autenticación falla
                        Toast.makeText(requireContext(), "Credenciales incorrectas"
                            , Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                Toast.makeText(requireContext(), "Todos los campos son obligatorios"
                    , Toast.LENGTH_SHORT).show()
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
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}