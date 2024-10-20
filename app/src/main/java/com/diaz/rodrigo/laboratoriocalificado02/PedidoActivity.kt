package com.diaz.rodrigo.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diaz.rodrigo.laboratoriocalificado02.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val numero = intent.getStringExtra("numero")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        binding.textNombreCliente.text = nombre
        binding.textNumeroCliente.text = numero
        binding.textProductos.text = productos
        binding.textDireccion.text = direccion

        binding.buttonLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numero"))
            startActivity(intent)
        }

        binding.buttonWhatsapp.setOnClickListener {
            val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$numero?text=${Uri.encode(mensaje)}"))
            startActivity(intent)
        }

        binding.buttonMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
