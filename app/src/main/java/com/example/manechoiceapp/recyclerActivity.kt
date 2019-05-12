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
    lateinit var hairtType: String
    lateinit var hairtTexture: String
    lateinit var hairtAbs: String
    lateinit var hairtFull: String
    lateinit var hT: String
    lateinit var hA: String
    lateinit var hF: String



    companion object {
        val TAG = MainActivity::class.java.simpleName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        handleReset()
//        handleProductRecommend()
        recommend()
        yourProduct.setOnClickListener {
            productTitle.text = "Your Products"
//            handleProductRecommend()
            recommend()
        }
        viewAllProductBtn.setOnClickListener {
            productTitle.text = "All Products"
            NetworkHelper()
                .lightWeightProduct {
                    list.clear()
                    list.addAll(it)
                }
            NetworkHelper()
                .heavyWeightProduct {
                    list.addAll(it)
                }
            NetworkHelper()
                .normalProduct {
                    list.addAll(it)
                }
            NetworkHelper()
                .volume {
                    list.addAll(it)
                    recyclerView.adapter?.notifyDataSetChanged()
                    productCount.text = list.size.toString() + " items"
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


        while (res.moveToNext()) {
            hairtType = res.getString(1)
            hairtTexture = res.getString(3)
            hairtAbs = res.getString(4)
            hairtFull = res.getString(6)

            if (hairtType == "Straight" && hairtTexture == "Loose" && hairtAbs == "Low" && hairtFull == "Thin") {
                NetworkHelper()
                    .fetchCombo1 {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                NetworkHelper()
                    .fetchCombo2 {
//                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            } else if (hairtType == "Wavy-Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Normal" && hairtFull == "Normal") {
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
            } else if (hairtType == "Wavy-Curly" && hairtTexture == "Somewhat-Wavy" && hairtAbs == "Normal" && hairtFull == "Normal") {
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

    fun recommend(){
        val res = dbHelper.allData


        while (res.moveToNext()) {
            hT = res.getString(1)
//            hairtTexture = res.getString(3)
            hA = res.getString(4)
            hF = res.getString(6)
            var s= "Straight"
            var wC= "Wavy-Curly"
            var cK= "Curly-Kinky"
            var kC= "Kinky-Coily"

            var l= "Low"
            var n= "Normal"
            var h= "High"

            var t= "Thin"
            var f= "Full"



            if (hT == "Straight" || hT == wC && hA == "Low" || hA == n && hF == "Thin" || hF == n){
                // l-w and v
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                    }
                NetworkHelper()
                    .volume {
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == s || hT == wC && hA == l || hA == n && hF == f ){
                // l-w
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == s || hT == wC && hA == h && hF == t || hF == n){
                //h-w and v
                NetworkHelper()
                    . heavyWeightProduct{
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    . volume{
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }


            }else if(hT == s || hT == wC && hA == h && hF == f){
                //h-w
                NetworkHelper()
                    .heavyWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == cK || hT == kC && hA == l || hA == n && hF == t || hF == n){
                //l-w and v
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    .volume {
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == cK || hT == kC && hA == l || hA == n && hF == f){
                //l-w
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == cK || hT == kC && hA == h && hF == t || hF == n){
                // h-w and v
                NetworkHelper()
                    .heavyWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    .volume {
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if(hT == cK || hT == kC && hA == h && hF == f){
                //h-w
                NetworkHelper()
                    .heavyWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else{
                NetworkHelper()
                    .normalProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }
        }

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
