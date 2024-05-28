package com.example.donsevero.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.donsevero.R
import com.example.donsevero.databinding.FragmentLoginSignupBinding

class LoginSignupFragment : Fragment() {

    private var _binding: FragmentLoginSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Aquí puedes configurar los listeners de los botones u otras interacciones

        binding.btnLoginSignupCrearCuenta.setOnClickListener {
            navegarARegisterFragment()
        }

        binding.btnLoginsignupIniciarSesion.setOnClickListener {
            navegarALoginFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navegarARegisterFragment() {
        val registerFragment = RegisterFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, registerFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }

    private fun navegarALoginFragment() {
        val loginFragment = LoginFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, loginFragment)
            .addToBackStack(null)  // Agregar al back stack para permitir retroceso
            .commit()
    }
}