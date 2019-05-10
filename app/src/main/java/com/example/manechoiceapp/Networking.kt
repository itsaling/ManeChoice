package com.example.manechoiceapp

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class NetworkHelper{
    fun fetchProducts(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/lle7/mainchoice/shampoo")
            .setTag(this)
            .setPriority(Priority.LOW)
            .build()
            .getAsObjectList(products::class.java, object : ParsedRequestListener<List<products>> {
                override fun onResponse(product: List<products>) {
                    callback(product)
                }

                override fun onError(anError: ANError?) {
                    //handle error
                }
            })
    }
}