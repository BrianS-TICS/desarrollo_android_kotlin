package com.example.listasandroid01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter:ArrayAdapter<*>
        val personas = mutableListOf("Laura", "Carlos", "Maria", "Sergio")

        val lvDatos = findViewById<ListView>(R.id.lvDatos)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, personas)

        lvDatos.adapter = arrayAdapter

        // Click a item
        lvDatos.setOnItemClickListener(){parent, view, position, id ->
            Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }

    }
}