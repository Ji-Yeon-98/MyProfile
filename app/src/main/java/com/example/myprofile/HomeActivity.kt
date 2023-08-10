package com.example.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var profile = arrayListOf<String>("추지연", "26", "ISFP")

        val tv_id = findViewById<TextView>(R.id.tv_id)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_age = findViewById<TextView>(R.id.tv_age)
        val tv_mbti = findViewById<TextView>(R.id.tv_mbti)

        val iv_profile = findViewById<ImageView>(R.id.iv_profile)

        //이미지 랜덤 등록
        val img = arrayListOf<Int>(R.drawable.dog1_circle, R.drawable.dog2_circle, R.drawable.dog3_circle, R.drawable.dog4_circle, R.drawable.dog1_circle)
        var imageIndex = (Math.random() * img.size).toInt() //0~4
        iv_profile.setImageResource(img[imageIndex])


        //아이디 입력값 로그인 페이지에서 받아온 뒤 변경
        val id = intent.getStringExtra("id")

        tv_id.setText(id)
        tv_name.setText(profile[0])
        tv_age.setText(profile[1])
        tv_mbti.setText(profile[2])


        //종료 버튼 누르면 activity 종료
        val btn_finish = findViewById<Button>(R.id.btn_finsih)
        btn_finish.setOnClickListener {
            finish()
        }

    }
}