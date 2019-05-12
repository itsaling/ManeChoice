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
    fun fetchAllProducts(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall")
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
    fun fetchCombo1(callback: (List<products>) -> Unit){
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
    fun fetchCombo2(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/shampoo")
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
    fun fetchCombo3(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=5&&id=13&&id=4&&id=25")
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
    fun fetchCombo4(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=3&&id=12&&id=17&&id=25")
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
    fun fetchCombo5(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=6&&id=11&&id=21&&id=30")
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
    fun fetchCombo6(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=4&&id=10&&id=17&&id=24")
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
    fun fetchCombo7(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=1&&id=7&&id=20&&id=26")
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
    fun fetchCombo8(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=5&&id=13&&id=16&&id=26")
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
    fun fetchCombo9(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=2&&id=9&&id=20&&id=27")
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
    fun fetchCombo10(callback: (List<products>) -> Unit){
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/testrepod/viewall?id=3&&id=8&&id=18&&id=28")
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
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products/volume")
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
        AndroidNetworking.get("https://my-json-server.typicode.com/rsamps1/products/heavy-weight")
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