package com.example.manechoiceapp.interfaces

import android.view.View

interface IQuestionController {
    fun moveToNextQuestion()
    fun handleAnswers(view: View)
}