package zou.yuchen.senegence.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import zou.yuchen.senegence.R
import zou.yuchen.senegence.model.RedditPost
import zou.yuchen.senegence.ui.viewholder.RedditPostViewholder

class RedditPostAdapter : RecyclerView.Adapter<RedditPostViewholder>() {
    private var postList: List<RedditPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditPostViewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vh_reddit_post, parent, false)
        return RedditPostViewholder(view)
    }

    override fun onBindViewHolder(holder: RedditPostViewholder, position: Int) {
        val post = postList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun updatePostList(newPosts: List<RedditPost>) {
        postList = newPosts
        notifyDataSetChanged()
    }
}