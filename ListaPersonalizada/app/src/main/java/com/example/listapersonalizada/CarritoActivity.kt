package com.example.listapersonalizada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_carrito.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class CarritoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val productoUser = intent.getSerializableExtra("productoUser") as Producto

        val url = "https://fakestoreapi.com/carts/${productoUser.id}"

        val listCarrito : MutableList<ProductoCarrito> = mutableListOf()
        val cola = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url,{ response ->
            if (!response.equals("null")) {
                val jDatos = JSONObject(response)
                val jArray = jDatos.getJSONArray("products")

                for (i in 0 until jArray.length()) {
                    if (jArray.length() == 0) {
                        break;
                    }
                    val jobject = jArray.getJSONObject(i)

                    var id = jobject.getString("productId").toString()
                    var cantidad = jobject.getString("quantity").toString()

                    listCarrito.add(i, ProductoCarrito(id, cantidad))
                }
            }
            val adapter = CarritoAdapter(this, listCarrito)
            lsCarrito.adapter = adapter
        },{})
        cola.add(solicitud)
    }
}