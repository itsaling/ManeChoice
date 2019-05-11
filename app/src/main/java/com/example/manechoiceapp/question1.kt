package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question1.*

class question1 : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        handleUpdate()

        prev.setOnClickListener {
            finish()
        }

    }

    fun moveToNextQuestion() {
        val result = Intent(this, question21::class.java)
        startActivity(result)
    }
    fun handleUpdate(){
        type1.setOnClickListener {
            try {
                dbHelper.updateData1("1", "Straight")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        type2.setOnClickListener {
            try {
                dbHelper.updateData1("1","Wavy-Curly")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        type3.setOnClickListener {
            try {
                dbHelper.updateData1("1","Curly-Kinky")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
        type4.setOnClickListener {
            try {
                dbHelper.updateData1("1","Kinky-Coily")
                moveToNextQuestion()
            }catch (e: Exception){
                e.printStackTrace()
                print("insert failed")
            }
        }
    }
}
