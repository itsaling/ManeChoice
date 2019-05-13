package com.example.manechoiceapp

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class NetworkHelper{
    fun fetchProducts(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/conditioner")
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

    fun lightWeightProduct(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products/light-weight")
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
    fun volume(callback: (List<products>) -> Unit) {
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products2/volume")
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
    fun heavyWeightProduct(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products2/heavy-weight")
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
    fun normalProduct(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products/normal")
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