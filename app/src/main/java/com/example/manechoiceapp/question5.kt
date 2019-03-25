package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question4.*
import kotlinx.android.synthetic.main.activity_question5.*

class question5 : AppCompatActivity(), View.OnClickListener, IQuestionController {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.short1 -> {
                handleAnswers(question5)
                moveToNextQuestion()
            }
            R.id.long1 -> {
                handleAnswers(question5)
                moveToNextQuestion()
            }
            R.id.medium -> {
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
        val question6Activity = Intent(this, question6::class.java)
        startActivity(question6Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question5)
        short1.setOnClickListener { onClick(short1) }
        long1.setOnClickListener { onClick(long1) }
        medium.setOnClickListener { onClick(medium) }
    }
}
