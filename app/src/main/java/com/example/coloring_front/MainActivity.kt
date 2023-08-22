package com.example.coloring_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val red : ImageView = findViewById(R.id.red)
        val green : ImageView = findViewById(R.id.green)
        val blue : ImageView = findViewById(R.id.blue)
        val all : ImageView = findViewById(R.id.all)
        val picture : Button = findViewById(R.id.picture)

        red.setOnClickListener{

        }

        green.setOnClickListener{

        }

        blue.setOnClickListener{

        }

        all.setOnClickListener{
            val gallery = Intent(this@MainActivity, GalleryActivity::class.java)
            gallery.apply {
                this.putExtra("gallery",0)
            }


        }

    }
}