package com.diaz.rodrigo.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diaz.rodrigo.laboratoriocalificado02.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegistrar.setOnClickListener {
            val nombre = binding.inputNombreCliente.text.toString()
            val numero = binding.inputNumeroCliente.text.toString()
            val productos = binding.inputProductos.text.toString()
            val direccion = binding.inputDireccion.text.toString()

            if (nombre.isEmpty() || numero.isEmpty() || productos.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, PedidoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("numero", numero)
                intent.putExtra("productos", productos)
                intent.putExtra("direccion", direccion)
                startActivity(intent)
            }
        }
    }
}
