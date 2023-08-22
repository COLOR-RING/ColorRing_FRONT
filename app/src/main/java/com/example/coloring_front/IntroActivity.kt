package com.example.coloring_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.coloring_front.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 1500)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}