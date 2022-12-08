package com.example.listapersonalizada

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_item_categoria.view.*
import kotlinx.android.synthetic.main.activity_item_filtrado.view.*

class ProductosPorCategoriaAdapter(private val mContext: Context, private val listaProductosFiltrados: List<ProductoMaterial>):
    ArrayAdapter<ProductoMaterial>(mContext, 0, listaProductosFiltrados) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.activity_item_filtrado, parent, false)
        val producto = listaProductosFiltrados[position]
        layout.tvNombreProducto.text = producto.nombre
        layout.descripcionNombre.text = producto.descripcion
        // layout.ivProducto = producto.nombre

        return layout
    }
}