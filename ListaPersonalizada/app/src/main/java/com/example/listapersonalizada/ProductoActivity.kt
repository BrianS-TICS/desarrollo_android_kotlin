package com.example.listapersonalizada

import android.graphics.Bitmap
import android.icu.number.Scale
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.VolleyError
import com.android.volley.VolleyLog
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val producto = intent.getSerializableExtra("producto") as Producto
        nombre_producto.text = producto.nombre
        precio_producto.text = "$${producto.precio}"
        descripcion_producto.text = producto.descripcion
        //foto_producto.setImageResource(producto.imagen)

        //Volley
        val cola = Volley.newRequestQueue(this)
        val imagenRequest = ImageRequest (
            producto.foto,
            {
                foto_producto.setImageBitmap(it)
            },
            foto_producto.layoutParams.width,
            foto_producto.layoutParams.height,
            ImageView.ScaleType.CENTER_CROP,
            Bitmap.Config.ARGB_8888,
            {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        cola.add(imagenRequest)
    }
}