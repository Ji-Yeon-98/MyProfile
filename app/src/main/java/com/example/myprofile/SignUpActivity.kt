package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_signup = findViewById<Button>(R.id.btn_signup)

        btn_signup.setOnClickListener {
            val et_name = findViewById<EditText>(R.id.et_name)
            val et_id = findViewById<EditText>(R.id.et_id)
            val et_pw = findViewById<EditText>(R.id.et_pw)

            val sName = et_name.text.toString()
            val sId = et_id.text.toString()
            val sPw = et_pw.text.toString()

            if (et_name.text.isNullOrBlank() || et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("Name", sName)
                intent.putExtra("Id", sId)
                intent.putExtra("Pw", sPw)
                setResult(RESULT_OK, intent)

                finish()
            }

        }

    }
}