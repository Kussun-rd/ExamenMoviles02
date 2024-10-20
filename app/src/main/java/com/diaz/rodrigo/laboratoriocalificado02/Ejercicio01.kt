package com.diaz.rodrigo.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.diaz.rodrigo.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShow.setOnClickListener {
            binding.viewGreenBox.visibility = View.VISIBLE
        }

        binding.buttonHide.setOnClickListener {
            binding.viewGreenBox.visibility = View.INVISIBLE
        }
    }
}

