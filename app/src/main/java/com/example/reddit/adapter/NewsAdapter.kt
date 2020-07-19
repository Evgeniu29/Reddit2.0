package com.example.reddit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reddit.R
import com.example.reddit.model.RedditNewsDataResponse

class NewsAdapter(var newsList: MutableList<RedditNewsDataResponse>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.news_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.bindItems(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(news: RedditNewsDataResponse) {

            val description = itemView.findViewById<TextView>(R.id.description)

            val author = itemView.findViewById<TextView>(R.id.author)

            val comments = itemView.findViewById<TextView>(R.id.comments)

            val time = itemView.findViewById<TextView>(R.id.time)


            val photo = itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.photo)

            description.text = news.title

            author.text = news.author

            comments.text = news.num_comments.toString()

            time.text = news.created.toString()

            Glide.with(itemView)
                .load(news.thumbnail).centerCrop()
                .placeholder(R.drawable.noimage).error(R.drawable.noimage)
                .fallback(R.drawable.noimage)
                .into(photo)
        }
    }

}