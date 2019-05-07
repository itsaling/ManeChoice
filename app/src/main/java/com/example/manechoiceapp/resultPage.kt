package com.example.manechoiceapp

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_resultpage.*

class resultPage : AppCompatActivity() {
    internal var dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultpage)
        handleView()
        handleReset()

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
        showText.setOnClickListener (
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("HAIR TYPE:" + res.getString(1) + "\n")
                    buffer.append("HAIR PATTERN:" + res.getString(2) + "\n")
                    buffer.append("HAIR TEXTURE:" + res.getString(3) + "\n")
                    buffer.append("HAIR LENGTH:" + res.getString(4) + "\n")
                    buffer.append("HAIR ABSORBENT:" + res.getString(5) + "\n")
                    buffer.append("HAIR FULLNESS:" + res.getString(6) + "\n")
                }
                resultView.setText(buffer.toString())

//                showDialog("Data Listing", buffer.toString())
            }
        )
    }
}
