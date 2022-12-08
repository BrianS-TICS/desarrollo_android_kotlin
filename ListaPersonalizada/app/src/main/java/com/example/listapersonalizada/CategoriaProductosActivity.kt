package com.example.listapersonalizada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_categoria_productos.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class CategoriaProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_productos)

        // Stat logic categorias
        val url = "https://fakestoreapi.com/products/categories"
        val listaCategorias : MutableList<Categoria> = mutableListOf()
        val cola = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url,{ response ->
            val arrDatos = JSONArray(response)
            for (i in 0 until arrDatos.length()){
                var nombre = arrDatos[i].toString()
                listaCategorias.add(i, Categoria( nombre ))
            }

            val adapter = CategoriasAdapter(this, listaCategorias)
            lsCategorias.adapter = adapter
        },{})
        cola.add(solicitud)

        // Cuando damos click a un elemento de la lista]
        lsCategorias.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductosPorCategoriaActivity::class.java)
            intent.putExtra("categorias", listaCategorias[position])
            startActivity(intent)
        }
    }
}