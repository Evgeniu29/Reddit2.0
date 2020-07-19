package com.example.reddit.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reddit.R
import com.example.reddit.extensions.inflate


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))
}