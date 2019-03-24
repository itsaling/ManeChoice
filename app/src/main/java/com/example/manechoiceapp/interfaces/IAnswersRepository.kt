package com.example.manechoiceapp.interfaces

import com.example.manechoiceapp.models.Answers

interface IAnswersRepository {
    fun recordAnswers(answers: Answers)
}