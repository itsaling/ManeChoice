package com.example.manechoiceapp.interfaces

import com.example.manechoiceapp.models.Answers

interface IAnswersController {
    fun deleteAnswer(answers: Answers)
    fun addAnswer(answers: Answers)
    fun answerCount(): Int
    fun getAnswer(pos: Int) : Answers
}