package com.example.manechoiceapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manechoiceapp.interfaces.IQuestionController
import com.example.manechoiceapp.models.Answers
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_question31.*
import kotlinx.android.synthetic.main.activity_question32.*

class question31 : AppCompatActivity(), View.OnClickListener, IQuestionController {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loose -> {
                handleAnswers(question31)
                moveToNextQuestion()
            }
            R.id.wavy1 -> {
                handleAnswers(question31)
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
        val question4Activity = Intent(this, question4::class.java)
        startActivity(question4Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question31)
        loose.setOnClickListener { onClick(loose) }
        wavy1.setOnClickListener { onClick(wavy1) }
//
//        prev.setOnClickListener {
//            finish()
//        }
    }
}
