package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question5.*

class question5 : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question5)
        handleInsert()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion(){
        val question2Activity = Intent(this, question6::class.java)
        startActivity(question2Activity)
    }

    fun handleInsert(){
        short1.setOnClickListener {
            try {
                dbHelper.updateData5("1", "Short")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        medium.setOnClickListener {
            try {
                dbHelper.updateData5("1","Medium")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        long1.setOnClickListener {
            try {
                dbHelper.updateData5("1","Long")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
