package com.cbellmont.ejercicioandroid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

interface MainActivityInterface {
    fun onPersonajeCliked(personaje: Personaje)
}

class MainActivity : AppCompatActivity(), MainActivityInterface{

    private lateinit var adapter : PersonajesAdapter
    private val listaPersonajes = loadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createRecyclerView()
    }

    private fun createRecyclerView() {
        adapter = PersonajesAdapter(this, listaPersonajes)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    private fun loadData() : List<Personaje>{
        val personaje1 = Personaje("Aragorn", "Humano", R.mipmap.aragorn, true)
        val personaje2 = Personaje("Gandalf", "Mago", R.mipmap.gandalf, true)
        val personaje3 = Personaje("Boromir", "Humano", R.mipmap.boromir, true)
        val personaje4 = Personaje("Legolas", "Elfo", R.mipmap.legolas, true)
        val personaje5 = Personaje("Orco Feo", "Orco", R.mipmap.orco, false)
        val personaje6 = Personaje("Smagu", "Dragon", R.mipmap.smagu, false)

        return mutableListOf(personaje1,personaje2,personaje3,personaje4,personaje5,personaje6).apply { shuffle() }
    }

    override fun onPersonajeCliked(personaje: Personaje) {
        startActivity(SecondActivity.getIntent(this, personaje))
    }
}