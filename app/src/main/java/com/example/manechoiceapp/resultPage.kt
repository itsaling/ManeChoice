package com.example.manechoiceapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.manechoiceapp.interfaces.IController
import kotlinx.android.synthetic.main.activity_question1.*
import kotlinx.android.synthetic.main.activity_resultpage.*

class resultPage : AppCompatActivity(){
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultpage)
        handleView()
        handleReset()
        productRec.setOnClickListener {
            val intent = Intent(this, recyclerActivity::class.java)
            startActivity(intent)
        }

    }
    fun showDialog(title : String,Message : String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }
    fun moveToHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun makeToast(text:String){
        Toast.makeText(this@resultPage, text,Toast.LENGTH_LONG ).show()
    }
    fun handleReset(){
        resetBtn.setOnClickListener{
            try {
                dbHelper.deleteData()
                moveToHome()

            }catch (e: Exception){
                e.printStackTrace()
                makeToast(e.message.toString())
            }
        }
    }
    fun handleView(){
        val res = dbHelper.allData
        val buffer = StringBuffer()
        while (res.moveToNext()) {
//                    buffer.append("ID :" + res.getString(0) + "\n")
            buffer.append("HAIR TYPE: \n" + res.getString(1) + "\n\n")
            buffer.append("HAIR PATTERN:\n" + res.getString(2) + "\n\n")
            buffer.append("HAIR TEXTURE:\n" + res.getString(3) + "\n\n")
            buffer.append("HAIR LENGTH:\n" + res.getString(5) + "\n\n")
            buffer.append("HAIR ABSORBENT:\n" + res.getString(4) + "\n\n")
            buffer.append("HAIR FULLNESS:\n" + res.getString(6) + "\n\n")
//            buffer.append(type1.toString())
        }
        resultView.setText(buffer.toString())


    }

}
