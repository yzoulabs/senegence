package zou.yuchen.senegence

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import zou.yuchen.senegence.model.RedditPost
import zou.yuchen.senegence.ui.RedditPostAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redditPostAdapter = RedditPostAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.post_rv)
        recyclerView.adapter = redditPostAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        val model = ViewModelProviders.of(this).get(RedditViewModel::class.java)
        model.getPosts().observe(this, Observer<List<RedditPost>>{ posts -> redditPostAdapter.updatePostList(posts!!)})
    }
}
