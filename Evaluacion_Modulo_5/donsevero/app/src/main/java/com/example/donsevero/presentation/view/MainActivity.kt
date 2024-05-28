package com.example.donsevero.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.donsevero.R
import com.example.donsevero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentFragmentTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Si no hay ningún estado guardado, agregamos el fragmento inicial
            currentFragmentTag = LoginSignupFragment::class.java.simpleName
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginSignupFragment(), currentFragmentTag)
                .commit()
        } else {
            // Si hay un estado guardado, restauramos el fragmento actual
            currentFragmentTag = savedInstanceState.getString("currentFragmentTag")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardamos el tag del fragmento actual
        outState.putString("currentFragmentTag", currentFragmentTag)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restauramos el tag del fragmento actual
        currentFragmentTag = savedInstanceState.getString("currentFragmentTag")
    }
}
