package com.example.myprofile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val et_id = findViewById<EditText>(R.id.et_id)
        val et_pw = findViewById<EditText>(R.id.et_pw)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signup)

        var sName:String = ""
        var sId:String = ""
        var sPw:String = ""

        //액티비티끼리 데이터 주고 받기 위한 함수
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {

                    sName = result.data?.getStringExtra("Name").toString()
                    sId = result.data?.getStringExtra("Id").toString()
                    sPw = result.data?.getStringExtra("Pw").toString()

                    et_id.setText(sId)
                    et_pw.setText(sPw)
                }
            }


        //로그인 버튼 : 아이디, 비밀번호 입력받아 HomeActivity에 전달
        btn_login.setOnClickListener {
            val userId = et_id.text.toString()
            val userPw = et_pw.text.toString()

            if (userId.isEmpty() || userPw.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)

                intent.putExtra("id", userId)
                intent.putExtra("pw", userPw)

                startActivity(intent)
            }
        }


        //회원가입 버튼 : 데이터 받아올 SignUpActivity 이동 + 실행
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

}