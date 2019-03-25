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

class question4 : AppCompatActivity(), View.OnClickListener, IQuestionController {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.low -> {
                handleAnswers(question4)
                moveToNextQuestion()
            }
            R.id.normal -> {
                handleAnswers(question4)
                moveToNextQuestion()
            }
            R.id.high -> {
                handleAnswers(question4)
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
        val question5Activity = Intent(this, question5::class.java)
        startActivity(question5Activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)
        low.setOnClickListener { onClick(low) }
        normal.setOnClickListener { onClick(normal) }
        high.setOnClickListener { onClick(high) }

//        prev.setOnClickListener {
//            finish()
//        }
    }
}
