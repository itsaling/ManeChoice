package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var dbHelper = DatabaseHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStart.setOnClickListener {
            handleInsert()
            val question1Activity = Intent(this, question1::class.java)
            startActivity(question1Activity)


        }
    }

    fun handleInsert() {
        dbHelper.insertData("", "", "", "", "", "")
    }

}
