package com.example.listapersonalizada

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_item_carrito.view.*
import kotlinx.android.synthetic.main.item_producto.view.*

class CarritoAdapter(private val mContext: Context, private val listaCarrito: List<ProductoCarrito>):
    ArrayAdapter<ProductoCarrito>(mContext, 0, listaCarrito) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.activity_item_carrito, parent, false)
        val productos = listaCarrito[position]
        if (productos.id !== "" || productos.id !== null){
            layout.tvCantidad.text = productos.cantidad
            layout.tvCodigo.text = productos.id
        }
        return layout
    }
}