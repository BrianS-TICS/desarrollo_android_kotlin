package com.example.listapersonalizada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val url = "https://randomuser.me/api/?results=25"
        val url = "https://fakestoreapi.com/users"

        val listaProductos : MutableList<Producto> = mutableListOf()
        val cola = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url,{ response ->
            val arrDatos = JSONArray(response)
            //val objeto = JSONObject(data)
            //val jArray = objeto.getJSONArray("results")
            for (i in 0 until arrDatos.length()){
                val jobject = arrDatos.getJSONObject(i)
                var name = jobject.getJSONObject("name")
                var first = name.getString("firstname").toString()
                var last = name.getString("lastname").toString()

                var email = jobject.getString("email").toString()
                var userName = jobject.getString("username").toString()
                /*
                var picture = jobject.getJSONObject("picture")
                var large = picture.getString("large")
                */
                var id = jobject.getString("id").toString()
                var nombre = "$first $last"
                listaProductos.add(i,Producto( id, nombre, email, userName))
            }

            val adapter = ProductosAdapter(this, listaProductos)
            lista.adapter = adapter
        },{})
        cola.add(solicitud)

        /*
        val producto1 = Producto("Cámara", 100.23, "Cámara diseñada para tomar fotos regulares", R.drawable.camara)
        val producto2 = Producto("Cámara compleja", 200.23, "Cámara diseñada para tomar fotos profecionales" ,R.drawable.camara)

        val listaProductos = listOf(producto1,producto2)
        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter
        */
        // Cuando damos click a un elemento de la lista]
        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }

    }
}