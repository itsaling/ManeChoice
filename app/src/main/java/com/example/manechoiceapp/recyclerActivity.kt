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
        handleProductRecommend()
        yourProduct.setOnClickListener {
            productTitle.text = "Your Products"
            list.clear()
            handleProductRecommend()
        }
        viewAllProductBtn.setOnClickListener {
            productTitle.text = "All Products"
            list.clear()
            handleViewAll()

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
    fun handleViewAll(){
        NetworkHelper()
            .lightWeightProduct {
//                list.clear()
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
                productCount.text =  list.size.toString()+  " items"

            }

        recyclerView.adapter = ProductAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun handleProductRecommend(){
        val res = dbHelper.allData


        while (res.moveToNext()) {
            hT = res.getString(1)
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

            if ((hT == s || hT == wC) && (hA == l) && (hF == t || hF == n)) {
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                NetworkHelper()
                    .volume {
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() +  " items"
                    }

            }else if((hT == s || hT == wC) && (hA == l) && hF == f ){
                // l-w
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }
            else if((hT == s || hT == wC || hT == cK || hT == kC) && (hA == n) && (hF == t || hF == n) ){
                // l-w
                NetworkHelper()
                    .normalProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    .volume{
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }
            else if((hT == s || hT == wC || hT == cK || hT == kC) && (hA == n) && hF == f ){
                // l-w
                NetworkHelper()
                    .normalProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if((hT == s || hT == wC) && hA == h && (hF == t || hF == n) ){
                //h-w and v
                //h-w
                NetworkHelper()
                    .heavyWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    .volume{
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }


            }else if((hT == s || hT == wC) && (hA == h && hF == f)){
                //h-w
                NetworkHelper()
                    .heavyWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if((hT == cK || hT == kC) && (hA == l) && (hF == t || hF == n)){
                //l-w and v
                NetworkHelper()
                    .volume {
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if((hT == cK || hT == kC) && (hA == l)&& hF == f){
                //l-w
                NetworkHelper()
                    .lightWeightProduct {
                        list.clear()
                        list.addAll(it)
                        recyclerView.adapter?.notifyDataSetChanged()
                        productCount.text = list.size.toString() + " items"
                    }

            }else if((hT == cK || hT == kC) && hA == h && (hF == t || hF == n)){
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

            }else if((hT == cK || hT == kC) && hA == h && hF == f){
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