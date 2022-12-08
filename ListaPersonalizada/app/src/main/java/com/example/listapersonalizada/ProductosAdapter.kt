package com.example.listapersonalizada

import android.content.Context
import android.graphics.Bitmap
import android.icu.number.Scale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductosAdapter(private val mContext:Context, private val listaProductos: List<Producto>):ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)
        val productos = listaProductos[position]
        layout.nombre.text = productos.nombre
        //Volley
        /*
        val cola = Volley.newRequestQueue(mContext)
        val imageRequest = ImageRequest (
            productos.foto,
            {
                layout.foto.setImageBitmap(it)
            },
            layout.foto.layoutParams.width,
            layout.foto.layoutParams.height,
            ImageView.ScaleType.CENTER_CROP,
            Bitmap.Config.ARGB_8888,
            {
                Toast.makeText(mContext, it.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        cola.add(imageRequest)
         */
        //layout.foto.setImageResource(productos.imagen)
        return layout
    }
}