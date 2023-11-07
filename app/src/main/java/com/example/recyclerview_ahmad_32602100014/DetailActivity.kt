package com.example.recyclerview_ahmad_32602100014

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val photo = intent.getIntExtra("photo", R.drawable.ic_launcher_foreground)
        val title = intent.getStringExtra("title") ?: "Judul Artikel"
        val description = intent.getStringExtra("description") ?: "Deskripsi Artikel"
        val keterangan = intent.getStringExtra("keterangan") ?: getString(R.string.keterangan_default)
        //tvDetailKeterangan.text = keterangan

        //tvDetailKeterangan.text = keterangan

        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailTitle: TextView = findViewById(R.id.tv_data_nama)
        val tvdetailDescription: TextView = findViewById(R.id.tv_item_name)
        val tvDetailKeterangan: TextView = findViewById(R.id.tv_detail_keterangan) //Tambahkan ini

        ivDetailPhoto.setImageResource(photo)
        tvDetailTitle.text = title
        tvdetailDescription.text = description
        tvDetailKeterangan.text = keterangan //Tambahkan ini
    }
}