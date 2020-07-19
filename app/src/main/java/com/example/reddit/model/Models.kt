package com.example.reddit.model

import ViewType
import android.os.Parcel
import android.os.Parcelable


data class RedditNewsItem(
    val author: String?,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String?,
    val url: String?
) : ViewType, Parcelable {

    override fun getViewType() = AdapterConstants.NEWS

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<RedditNewsItem> = object : Parcelable.Creator<RedditNewsItem> {
            override fun createFromParcel(source: Parcel): RedditNewsItem = RedditNewsItem(source)
            override fun newArray(size: Int): Array<RedditNewsItem?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(),
        source.readString().toString(), source.readInt(), source.readLong(), source.readString(), source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(author)
        dest?.writeString(title)
        dest?.writeInt(numComments)
        dest?.writeLong(created)
        dest?.writeString(thumbnail)
        dest?.writeString(url)
    }
}