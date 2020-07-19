package com.example.reddit.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.R
import com.example.reddit.extensions.getFriendlyTime
import com.example.reddit.extensions.inflate
import com.example.reddit.model.RedditNewsItem


class NewsDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item) {

                private val imgThumbnail = itemView.photo
                private val description = itemView.description
                private val author = itemView.author
                private val comments = itemView.comments
                private val time = itemView.time
            }

        fun bind(item: RedditNewsItem) {
            imgThumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()

            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url)}
        }
    })
}