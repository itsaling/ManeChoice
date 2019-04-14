package com.example.manechoiceapp

import android.content.Context
import com.example.manechoiceapp.interfaces.IAnswersRepository
import com.example.manechoiceapp.models.Answers

class hairDBRepository (val ctx: Context) : IAnswersRepository{

    val db: hairDatabase

    init {
        db = hairDatabase(ctx)
    }

    override fun getCount(): Int {
        return db.getAnswers().size
    }

    override fun getAnwser(id: Int): Answers {
        return db.getAnswer(id)!!
    }

    override fun getAll(): List<Answers> {
        return db.getAnswers()
    }

    override fun remove(answers: Answers) {
        db.deleteAnswer(answers)
    }

    override fun replace(answers: Answers) {
        db.updateAnswer(answers)
    }

    override fun addAnswer(answers: Answers) {
        db.addAnswer(answers)
    }

}