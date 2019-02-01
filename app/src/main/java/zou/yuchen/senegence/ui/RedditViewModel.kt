package zou.yuchen.senegence.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zou.yuchen.senegence.model.RedditPost
import zou.yuchen.senegence.network.RedditRestClient

class RedditViewModel : ViewModel() {
    private lateinit var posts: MutableLiveData<List<RedditPost>>

    fun getPosts(): LiveData<List<RedditPost>> {
        if (!::posts.isInitialized) {
            posts = MutableLiveData()
            loadPosts()
        }

        return posts
    }

    private fun loadPosts() {
        RedditRestClient.getRedditApi().getTopPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { response ->
                val newPosts = ArrayList<RedditPost>()
                if (response != null) {
                    response.data.children.forEach { postContainer ->
                        newPosts.add(postContainer.data)
                    }
                }

                posts.value = newPosts
            }
            .subscribe()
    }
}