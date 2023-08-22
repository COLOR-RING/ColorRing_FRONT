package com.example.coloring_front

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


        setContentView(R.layout.activity_main)

        val gallery = intent.getIntExtra("gallery",0)

        Log.d("gallery","" + gallery)

        val resultGallery = Intent()

        resultGallery.putExtra("result",resultGallery)

        setResult(Activity.RESULT_OK,resultGallery)
        finish()
    }
}