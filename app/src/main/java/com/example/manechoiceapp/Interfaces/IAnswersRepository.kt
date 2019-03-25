package com.example.manechoiceapp.Interfaces

import com.example.manechoiceapp.Model.Answers

interface IAnswersRepository {
    fun recordAnsers(answers: Answers)
}