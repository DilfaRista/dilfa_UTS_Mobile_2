package com.dilfa.dilfauts4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SuperheroDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        val img: ImageView = findViewById(R.id.img_item_photo)
        val nameS: TextView = findViewById(R.id.tv_item_name)
        val descS: TextView = findViewById(R.id.tv_item_description)

        val bundle: Bundle? = intent.extras
        val nameSuperhero = bundle?.getString("nameS")
        val imgid = bundle?.getInt("img")
        val descSuperhero = bundle?.getString("descS")

        nameS.text = nameSuperhero
        descS.text = descSuperhero
        imgid?.let { img.setImageResource(it) }
    }
}