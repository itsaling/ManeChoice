package com.example.manechoiceapp.interfaces

import com.example.manechoiceapp.models.Answers

interface IAnswersRepository {
    fun getCount(): Int
    fun getAnwser(id: Int): Answers
    fun getAll(): List<Answers>
//    fun remove(answers: Answers)
    fun replace(answers: Answers)
//    fun addAnswer(answers: Answers)
}