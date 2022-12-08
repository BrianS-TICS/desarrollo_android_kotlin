package com.example.listapersonalizada

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_item_categoria.view.*
import kotlinx.android.synthetic.main.item_producto.view.*

class CategoriasAdapter(private val mContext:Context, private val listaCategorias: List<Categoria>):ArrayAdapter<Categoria>(mContext, 0, listaCategorias) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.activity_item_categoria, parent, false)
        val categorias = listaCategorias[position]
        layout.descripcionNombre.text = categorias.nombre

        return layout
    }
}