package com.example.manechoiceapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*

class recyclerActivity : AppCompatActivity(),IController {
    val list : MutableList<products> = mutableListOf()
    override val product: List<products> = list

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        connectNetwork()
        yourProduct.setOnClickListener {
            productTitle.text = "Your Products"
            connectNetwork()
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
}

interface IController{
    val product: List<products>
}