package zou.yuchen.senegence.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import zou.yuchen.senegence.R
import zou.yuchen.senegence.model.RedditPost

class RedditPostViewholder(postView: View) : RecyclerView.ViewHolder(postView), RedditPostView {

    private val titleView: TextView = postView.findViewById(R.id.title)
    private val authorView: TextView = postView.findViewById(R.id.author)
    private val imageView: ImageView = postView.findViewById(R.id.image)

    private val presenter: RedditPostPresenter = RedditPostPresenter(this)

    fun bind(post: RedditPost) {
        presenter.bindPost(post)
    }

    override fun setTitle(title: String) {
        titleView.text = title
    }

    override fun setAuthor(author: String) {
        authorView.text = author
    }

    override fun setImage(imageUrl: String) {
        Picasso.get()
            .load(imageUrl)
            .into(imageView)
    }
}