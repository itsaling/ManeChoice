package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question31.*

class question31 : AppCompatActivity(){
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question31)
        handleInsert()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion(){
        val question2Activity = Intent(this, question4::class.java)
        startActivity(question2Activity)
    }

    fun handleInsert(){
        loose.setOnClickListener {
            try {
                dbHelper.updateData3("1", "Loose")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        wavy1.setOnClickListener {
            try {
                dbHelper.updateData3("1", "Somewhat-Wavy")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
