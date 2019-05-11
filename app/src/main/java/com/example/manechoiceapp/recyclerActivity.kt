package com.example.manechoiceapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.manechoiceapp.interfaces.IController
import kotlinx.android.synthetic.main.activity_recycler.*

class recyclerActivity : AppCompatActivity(), IController {
    val list : MutableList<products> = mutableListOf()
    override val product: List<products> = list
    internal var dbHelper = DatabaseHelper(this)

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
//        connectNetwork()
        handleReset()
        handleProductRecommend()
        yourProduct.setOnClickListener {
            productTitle.text = "Your Products"
//            connectNetwork()
//            handleProductRecommend()
        }
        viewAllProductBtn.setOnClickListener {
            productTitle.text = "All Products"
            NetworkHelper()
                .fetchAllProducts {
                    list.clear()
                    list.addAll(it)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            recyclerView.adapter = ProductAdapter(this)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    fun connectNetwork(){
        NetworkHelper()
            .fetchProducts {
                list.clear()
                list.addAll(it)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        recyclerView.adapter = ProductAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun moveToHome(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun handleProductRecommend(){
        val res = dbHelper.allData
        var hairtType: String
        var hairtTexture: String
        var hairtAbs: String
        var hairtFull: String

        while (res.moveToNext()) {
            hairtType = res.getString(1)
            hairtTexture = res.getString(3)
            hairtAbs = res.getString(5)
            hairtFull = res.getString(6)

            if (hairtType == "Straight" && hairtTexture == "Loose" && hairtAbs == "Low" && hairtFull == "Thin") {
                NetworkHelper()
                    .fetchCombo1 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Medium" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo2 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Kinky-Coily" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Low" && hairtFull == "Full") {
                NetworkHelper()
                    .fetchCombo3 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Wavy-Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "High" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo4 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Straight" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "High" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo5 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Kinky-Coily" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Low" && hairtFull == "Thin") {
                NetworkHelper()
                    .fetchCombo6 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Wavy-Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Medium" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo7 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Wavy-Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "High" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo8 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Kinky-Coily" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "High" && hairtFull == "Normal") {
                NetworkHelper()
                    .fetchCombo9 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else if (hairtType == "Kinky-Coily" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "High" && hairtFull == "Full") {
                NetworkHelper()
                    .fetchCombo10 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            } else {
                NetworkHelper()
                    .fetchProducts {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
            }
        }
        recyclerView.adapter = ProductAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun handleReset(){
        resetBtn.setOnClickListener{
            try {
                dbHelper.deleteData()
                moveToHome()

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
