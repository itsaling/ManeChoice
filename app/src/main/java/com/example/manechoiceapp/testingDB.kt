package com.example.manechoiceapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_testing_db.*

class testingDB : AppCompatActivity() {
    lateinit var hairtType: String
    lateinit var hairtTexture: String
    lateinit var hairtAbs: String
    lateinit var hairtFull: String

    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_db)

        handleProductRecommend()
    }
    fun handleProductRecommend() {
        val res = dbHelper.allData


        while (res.moveToNext()) {
            hairtType = res.getString(1)
            hairtTexture = res.getString(3)
            hairtAbs = res.getString(4)
            hairtFull = res.getString(6)
        }

        hairTypeTv.text= hairtType
        hairTextTv.text = hairtTexture
        hairAbsTv.text = hairtAbs
        hairFullTv.text = hairtFull

    }
}
