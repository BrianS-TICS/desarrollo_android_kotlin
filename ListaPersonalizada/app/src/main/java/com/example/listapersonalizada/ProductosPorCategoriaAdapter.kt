package com.example.listapersonalizada

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_item_categoria.view.*
import kotlinx.android.synthetic.main.activity_item_filtrado.view.*

class ProductosPorCategoriaAdapter(private val mContext:Context, private val listaProductosFiltrados: List<ProductoMaterial>):ArrayAdapter<ProductoMaterial>(mContext, 0, listaProductosFiltrados) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.activity_item_filtrado, parent, false)
        val producto = listaProductosFiltrados[position]
        layout.tvNombreProducto.text = producto.nombre
        layout.tvDescripcion.text = producto.descripcion
        layout.tvPrecioProducto.text = producto.precio + " $"

        val cola = Volley.newRequestQueue(mContext)
        val imageRequest = ImageRequest (
            producto.foto,
            {
                layout.ivProducto.setImageBitmap(it)
            },
            layout.ivProducto.layoutParams.width,
            layout.ivProducto.layoutParams.height,
            ImageView.ScaleType.CENTER_CROP,
            Bitmap.Config.ARGB_8888,
            {
                Toast.makeText(mContext, it.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        cola.add(imageRequest)

        return layout
    }
}