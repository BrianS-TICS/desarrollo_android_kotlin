package com.example.listapersonalizada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.android.synthetic.main.activity_productos_por_categoria.*
import org.json.JSONArray

class ProductosPorCategoriaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos_por_categoria)

        val categoria = intent.getSerializableExtra("categoria") as Categoria

        val url = "https://fakestoreapi.com/products/category/${categoria.nombre}"

        val listaProductosFiltrados : MutableList<ProductoMaterial> = mutableListOf()
        val cola = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url,{ response ->
            val arrDatos = JSONArray(response)

            for (i in 0 until arrDatos.length()){
                val jobject = arrDatos.getJSONObject(i)
                var nombre = jobject.getString("title").toString()
                var precio = jobject.getString("price").toString()
                var descripcion = jobject.getString("description").toString()
                var image = jobject.getString("image").toString()
                listaProductosFiltrados.add(i, ProductoMaterial( nombre,  precio, descripcion, image))
            }

            val adapter = ProductosPorCategoriaAdapter(this, listaProductosFiltrados)
            lvProductosFiltrados.adapter = adapter
        },{})
        cola.add(solicitud)
    }
}