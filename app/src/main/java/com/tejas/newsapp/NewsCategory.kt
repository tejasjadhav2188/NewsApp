package com.tejas.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class NewsCategory : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var categoryList : ArrayList<Category>
    private lateinit var newsCategoryAdapter: NewsCategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_category)
        init()
    }

    private fun init(){
        recyclerView = findViewById(R.id.categoryRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this,2)

        categoryList = ArrayList()
        addData()

        newsCategoryAdapter = NewsCategoryAdapter(categoryList)
        recyclerView.adapter = newsCategoryAdapter

        newsCategoryAdapter.onItemClick = {
            val intent = Intent(this , MainActivity::class.java)
            intent.putExtra("category",it.Name)
            startActivity(intent)
        }

    }

    private fun addData(){
        categoryList.add(Category(R.drawable.business,"Business"))
        categoryList.add(Category(R.drawable.entertainment,"Entertainment"))
        categoryList.add(Category(R.drawable.general,"General"))
        categoryList.add(Category(R.drawable.healthjfif,"Health"))
        categoryList.add(Category(R.drawable.sport_category,"Sports"))
        categoryList.add(Category(R.drawable.science,"Science"))
        categoryList.add(Category(R.drawable.technology,"Technology"))

    }
}