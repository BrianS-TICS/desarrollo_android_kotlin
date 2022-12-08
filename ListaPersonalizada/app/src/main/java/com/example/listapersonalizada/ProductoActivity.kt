package com.example.listapersonalizada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_producto.*
import org.json.JSONArray

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto
        x.text = producto.nombre
        tvUserCorreo.text = producto.correo
        tvUsername.text = producto.nombreUsuario


        btnCategorias.setOnClickListener{
            val intent = Intent(this, CategoriaProductosActivity::class.java)
            startActivity(intent)
        }

        btnCarrito.setOnClickListener{
            val intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)
        }

    }
}