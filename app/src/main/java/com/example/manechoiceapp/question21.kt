package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question21.*

class question21 : AppCompatActivity(), View.OnClickListener, IQuestionController {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.typeA -> {
                handleAnswers(question21)
                moveToNextQuestion()
            }
            R.id.typeB -> {
                handleAnswers(question21)
                moveToNextQuestion()
            }
            R.id.typeC -> {
                handleAnswers(question21)
                moveToNextQuestion()
            }
            R.id.typeD -> {
                handleAnswers(question21)
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
        val question2Activity = Intent(this, question31::class.java)
        startActivity(question2Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question21)
        typeA.setOnClickListener { onClick(typeA) }
        typeB.setOnClickListener { onClick(typeB) }
        typeC.setOnClickListener { onClick(typeC) }
        typeD.setOnClickListener { onClick(typeD) }

        prev.setOnClickListener {
            finish()
        }
    }
}
