package com.example.recyclerview_ahmad_32602100014

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var animals: RecyclerView
    private val list = ArrayList<Animals>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animals = findViewById(R.id.animals)
        animals.setHasFixedSize(true)

        list.addAll(getListAnimals())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAnimals(): ArrayList<Animals> {
        val dataName = resources.getStringArray(R.array.animals_name)
        val dataDescription = resources.getStringArray(R.array.description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataKeterangan = resources.getStringArray(R.array.detail)
        val listAnimals = ArrayList<Animals>()
        for (i in dataName.indices) {
            val animals = Animals(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataKeterangan[i]
            )
            listAnimals.add(animals)
        }
        return listAnimals
    }

    private fun showRecyclerList() {
        animals.layoutManager = LinearLayoutManager(this)
        val listAnimalsAdapter = ListAnimalsAdapter(list)
        animals.adapter = listAnimalsAdapter

        listAnimalsAdapter.setOnItemClickCallback(object : ListAnimalsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Animals) {
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra("photo", data.photo)
                detailIntent.putExtra("title", data.name)
                detailIntent.putExtra("description", data.description)
                detailIntent.putExtra("keterangan", data.keterangan)
                startActivity(detailIntent)
            }
        })
    }
}