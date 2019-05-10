package com.example.manechoiceapp

import android.app.Application
import com.androidnetworking.AndroidNetworking


class ProductApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}