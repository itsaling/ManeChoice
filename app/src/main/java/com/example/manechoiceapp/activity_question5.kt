package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_question5.*

class activity_question5 : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.short -> {
                handleAnswers(question5)
                moveToNextQuestion()
            }
            R.id.medium -> {
                handleAnswers(question5)
                moveToNextQuestion()
            }
            R.id.long -> {
                handleAnswers(question5)
                moveToNextQuestion()
            }

        }
    }

    override fun handleAnswers(view: View){
        val choice = view.id.toString()

        val answer = Answers(choice)
        val json: String = Gson().toJson(answer)

        val data = Intent()
        data.putExtra("ANSWER_KEY", json)

        setResult(Activity.RESULT_OK, data)

    }

    override fun moveToNextQuestion(){
        val question6Activity = Intent(this, question5::class.java)
        startActivity(question6Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        medium.setOnClickListener { onClick(medium) }
        short.setOnClickListener { onClick(short) }
        long.setOnClickListener { onClick(long) }


        prev.setOnClickListener {
            finish()
        }


    }
}
