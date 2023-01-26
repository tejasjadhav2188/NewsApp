package com.tejas.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsCategoryAdapter(private val categoryList : ArrayList<Category>) :
    RecyclerView.Adapter<NewsCategoryViewHolder>() {

    var onItemClick : ((Category)->Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_news,parent,false)
        return NewsCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsCategoryViewHolder, position: Int) {
        val currItem = categoryList[position]
        holder.categoryImage.setImageResource(currItem.Image)
        holder.categoryTitle.text = currItem.Name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currItem)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}
class NewsCategoryViewHolder(categoryView : View): RecyclerView.ViewHolder(categoryView){
    val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
    val categoryTitle : TextView = categoryView.findViewById(R.id.categoryTitle)
}