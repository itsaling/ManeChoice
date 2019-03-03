package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question1.*

class question1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        next.setOnClickListener {
            val question2Activity = Intent(this, question2::class.java)
            startActivity(question2Activity)
        }
        prev.setOnClickListener {
            finish()
        }
    }
}
