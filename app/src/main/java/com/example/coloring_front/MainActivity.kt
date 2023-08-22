package com.example.coloring_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.coloring_front.databinding.ActivityIntroBinding
import com.example.coloring_front.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

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

