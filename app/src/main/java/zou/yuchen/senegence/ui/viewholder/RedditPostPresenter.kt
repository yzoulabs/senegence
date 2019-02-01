package zou.yuchen.senegence.ui.viewholder

import zou.yuchen.senegence.model.RedditPost

class RedditPostPresenter(val view: RedditPostView) {
    fun bindPost(post: RedditPost) {
        view.setTitle(post.title)
        view.setAuthor(post.author)
        view.setImage(post.url)
    }
}