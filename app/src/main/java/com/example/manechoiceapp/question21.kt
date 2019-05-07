package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question21.*

class question21 : AppCompatActivity(){
    internal var dbHelper = DatabaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question21)
        handleInsert()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion(){
        val question2Activity = Intent(this, question31::class.java)
        startActivity(question2Activity)
    }

    fun handleInsert(){
        typeA.setOnClickListener {
            try {
                dbHelper.updateData2("1","Type A")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        typeB.setOnClickListener {
            try {
                dbHelper.updateData2("1","Type B")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        typeC.setOnClickListener {
            try {
                dbHelper.updateData2("1","Type C")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        typeD.setOnClickListener {
            try {
                dbHelper.updateData2("1","Type D")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
