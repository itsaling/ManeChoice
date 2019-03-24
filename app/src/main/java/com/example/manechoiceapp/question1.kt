package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question1.*

class question1 : AppCompatActivity(), View.OnClickListener, IQuestionController{

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.type1 -> {
                handleAnswers(question1)
                moveToNextQuestion()
            }
            R.id.type2 -> {
                handleAnswers(question1)
                moveToNextQuestion()
            }
            R.id.type3 -> {
                handleAnswers(question1)
                moveToNextQuestion()
            }
            R.id.type4 -> {
                handleAnswers(question1)
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
        val question2Activity = Intent(this, question2::class.java)
        startActivity(question2Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)

        type1.setOnClickListener { onClick(type1) }
        type2.setOnClickListener { onClick(type2) }
        type3.setOnClickListener { onClick(type3) }
        type4.setOnClickListener { onClick(type4) }

        prev.setOnClickListener {
            finish()
        }


    }
}
