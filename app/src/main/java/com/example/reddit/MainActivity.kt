package com.example.reddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var newsList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsList = findViewById(R.id.news_list) as RecyclerView?
        newsList?.setHasFixedSize(true) // use this setting to improve performance
        newsList?.layoutManager = LinearLayoutManager(this)


    }



}