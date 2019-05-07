package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question4.*

class question4 : AppCompatActivity(){
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)
        handleInsert()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion(){
        val question2Activity = Intent(this, question5::class.java)
        startActivity(question2Activity)
    }

    fun handleInsert(){
        low.setOnClickListener {
            try {
                dbHelper.updateData4("1", "Low")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        normal.setOnClickListener {
            try {
                dbHelper.updateData4("1","Normal")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        high.setOnClickListener {
            try {
                dbHelper.updateData4("1","High")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
