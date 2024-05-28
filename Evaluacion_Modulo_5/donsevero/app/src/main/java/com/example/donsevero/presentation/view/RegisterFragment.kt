package com.example.donsevero.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.donsevero.R
import com.example.donsevero.databinding.FragmentRegisterBinding
import com.example.donsevero.domain.UseCase
import com.example.donsevero.data.model.Transaccion
import com.example.donsevero.data.model.User
import com.example.donsevero.objectUtil.IdGenerator
import com.example.donsevero.presentation.viewmodel.TransaccionViewModel
import com.example.donsevero.presentation.viewmodel.UserViewModel
import com.example.donsevero.presentation.viewmodel.ViewModelFactory
import com.example.donsevero.data.repository.transaccion.TransaccionImplement
import com.example.donsevero.data.repository.transaccion.Transacciones
import com.example.donsevero.user.Users
import com.example.donsevero.user.UsersRepositoryImplement
import java.util.Date

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
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
            Log.i("Register Usuarios", it.toString())
        }

        val transaccionViewModel: TransaccionViewModel by viewModels({ requireActivity() }) {viewModelFactory}

        transaccionViewModel.loadTransaccionesList()
        transaccionViewModel.transaccionesListLD.observe(viewLifecycleOwner){
            Log.i("Register Transacciones", it.toString())
        }

        transaccionViewModel.loadNuevaTransaccion(
            Transaccion(IdGenerator.generateUniqueId(),
                1,
                2,
                9999,
                Date())
        )
        transaccionViewModel.nuevaTransaccionLD.observe(viewLifecycleOwner){
            Log.i("Register Nueva Transaccion", it.toString())
        }

        binding.btnRegisterCrearCuenta.setOnClickListener {
            // Obtener los datos del formulario
            val nombre = binding.editTextRegisterNombre.text.toString()
            val apellido = binding.editTextRegisterApellido.text.toString()
            val correo = binding.editTextRegisterCorreo.text.toString()
            val contraseña = binding.editTextRegisterContraseA.text.toString()
            val confirmarContraseña = binding.editTextRegisterConfirmContraseA.text.toString()
            val saldo = 0.0


            // Verificar si todos los campos están completos
            // y la contraseña coincide con la confirmación
            if (nombre.isNotEmpty() && apellido.isNotEmpty()
                && correo.isNotEmpty() && contraseña.isNotEmpty()) {

                if (contraseña == confirmarContraseña) {

                    // Crear un nuevo usuario
                    val newUser = User(
                        IdGenerator.generateUniqueId(),
                        nombre,
                        apellido,
                        correo,
                        contraseña,
                        saldo)

                    // Registrar el nuevo usuario usando el ViewModel compartido
                    userViewModel.loadAddUser(newUser)

                    Toast.makeText(requireContext()
                        , "Registro Exitoso"
                        , Toast.LENGTH_SHORT).show()

                    navegarALoginFragment()

                } else  {
                    Toast.makeText(requireContext()
                        , "Las contraseñas no coinciden"
                        , Toast.LENGTH_SHORT).show()
                }
            }
            else {
                // Mostrar un mensaje de error si algún campo está vacío o las contraseñas no coinciden
                Toast.makeText(requireContext()
                    , "Todos los campos son obligatorios"
                    , Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navegarALoginFragment() {
        val loginFragment = LoginFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, loginFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}