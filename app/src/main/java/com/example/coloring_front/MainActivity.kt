package com.example.coloring_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.coloring_front.databinding.ActivityIntroBinding
import com.example.coloring_front.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.picture.setOnClickListener {
            //갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }

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

    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){

        //결과 코드 OK , 결가값 null 아니면
        if(it.resultCode == RESULT_OK && it.data != null){
            //값 담기
            val uri  = it.data!!.data

            //화면에 보여주기
            Glide.with(this)
                .load(uri) //이미지
                .into(binding.galleryPic) //보여줄 위치
        }
    }
}

