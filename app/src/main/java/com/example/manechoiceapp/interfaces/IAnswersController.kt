package com.example.manechoiceapp.interfaces

import com.example.manechoiceapp.models.Answers

interface IAnswersController {
    fun recordAnswer(answers: Answers)
}