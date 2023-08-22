package com.example.coloring_front

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.coloring_front.databinding.ActivityIntroBinding
import com.example.coloring_front.databinding.ActivityMainBinding
import java.io.File
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val REVIEW_MIN_LENGTH = 10
        // 갤러리 권한 요청
        const val REQ_GALLERY = 1

        // API 호출시 Parameter key값
        const val PARAM_KEY_IMAGE = "image"
        const val PARAM_KEY_PRODUCT_ID = "product_id"
        const val PARAM_KEY_REVIEW = "review_content"
        const val PARAM_KEY_RATING = "rating"
    }

    // 이미지를 결과값으로 받는 변수
    private val imageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
            result ->
        if(result.resultCode == RESULT_OK){
            // 이미지를 받으면 ImageView에 적용한다
            val imageUri = result.data?.data
            imageUri?.let{

                // 서버 업로드를 위해 파일 형태로 변환한다
                imageFile = File(getRealPathFromURI(it))

                // 이미지를 불러온다
                Glide.with(this)
                    .load(imageUri)
                    .fitCenter()
                    .apply(RequestOptions().override(500,500))
                    .into(binding.galleryPic)
            }
        }
    }

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

        val red : CheckBox = findViewById(R.id.redCheckBox)
        val green : CheckBox = findViewById(R.id.greenCheckBox)
        val blue : CheckBox = findViewById(R.id.blueCheckBox)

        val checkBoxSelectAll = findViewById<CheckBox>(R.id.allCheckBox)

        val picture : Button = findViewById(R.id.picture)





        red.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 체크박스가 체크되었을 때의 동작
                Toast.makeText(this, "적색을 선택하셨습니다", Toast.LENGTH_SHORT).show()
            } else {
                // 체크박스가 해제되었을 때의 동작
                Toast.makeText(this, "선택을 취소하셨습니다", Toast.LENGTH_SHORT).show()
            }
        }

        green.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 체크박스가 체크되었을 때의 동작
                Toast.makeText(this, "녹색을 선택하셨습니다", Toast.LENGTH_SHORT).show()
            } else {
                // 체크박스가 해제되었을 때의 동작
                Toast.makeText(this, "선택을 취소하셨습니다", Toast.LENGTH_SHORT).show()
            }
        }


        blue.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 체크박스가 체크되었을 때의 동작
                Toast.makeText(this, "청색을 선택하셨습니다", Toast.LENGTH_SHORT).show()
            } else {
                // 체크박스가 해제되었을 때의 동작
                Toast.makeText(this, "선택을 취소하셨습니다", Toast.LENGTH_SHORT).show()
            }
        }


        val checkBoxes = arrayOf(
            findViewById<CheckBox>(R.id.redCheckBox),
            findViewById<CheckBox>(R.id.greenCheckBox),
            findViewById<CheckBox>(R.id.blueCheckBox)
        )

        checkBoxSelectAll.setOnCheckedChangeListener { _, isChecked ->
            for (checkBox in checkBoxes) {
                checkBox.isChecked = isChecked
            }
        }

        for (checkBox in checkBoxes) {
            checkBox.setOnCheckedChangeListener { _, _ ->
                if (!checkBox.isChecked) {
                    checkBoxSelectAll.isChecked = false
                }
            }
        }



        picture.setOnClickListener {
//            val gallery = Intent(this@MainActivity, GalleryActivity::class.java)
//                gallery.apply {
//                this.putExtra("gallery", 0)
//            }


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

