package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question6.*

class question6 : AppCompatActivity(), View.OnClickListener, IQuestionController {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.thin -> {
                handleAnswers(question6)
                moveToNextQuestion()
            }
            R.id.normal -> {
                handleAnswers(question6)
                moveToNextQuestion()
            }
            R.id.full -> {
                handleAnswers(question6)
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
        val resultActivity = Intent(this, resultPage::class.java)
        startActivity(resultActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question6)
        thin.setOnClickListener { onClick(thin) }
        normal.setOnClickListener { onClick(normal) }
        full.setOnClickListener { onClick(full) }
    }
}
