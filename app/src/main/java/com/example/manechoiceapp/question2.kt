package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question1.*

class question2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)
//        next.setOnClickListener {
//            val question3Activity = Intent(this, question3::class.java)
//            startActivity(question3Activity)
//        }
        prev.setOnClickListener {
            finish()
        }
    }
}
