package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question6.*

class question6 : AppCompatActivity(){
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question6)
        handleInsert()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion(){
        val question2Activity = Intent(this, resultPage::class.java)
        startActivity(question2Activity)
    }

    fun handleInsert(){
        thin.setOnClickListener {
            try {
                dbHelper.updateData6("1", "Thin")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        normal.setOnClickListener {
            try {
                dbHelper.updateData6("1","Normal")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        full.setOnClickListener {
            try {
                dbHelper.updateData6("1","Full")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
