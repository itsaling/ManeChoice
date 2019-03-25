package com.example.manechoiceapp.Interfaces

import android.view.View

interface IQuestionController {
    fun moveToNextQuestion()
    fun handleAnswers(view: View)
}