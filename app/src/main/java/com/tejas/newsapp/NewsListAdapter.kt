package com.tejas.newsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val listener : NewsItemClicked ):
    RecyclerView.Adapter<NewsViewHolder>() {

    private val items : ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    fun updateNews(updatednewsArray:ArrayList<News>){
        items.clear()
        items.addAll(updatednewsArray)
        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
    val titleView : TextView = itemView.findViewById(R.id.title)
    val author : TextView = itemView.findViewById(R.id.TextView)
    val imageView : ImageView = itemView.findViewById(R.id.ImageView)
}

interface NewsItemClicked{
    fun onItemClicked(item:News)
}