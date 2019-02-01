package zou.yuchen.senegence.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import zou.yuchen.senegence.R
import zou.yuchen.senegence.model.RedditPost
import android.support.v7.widget.DividerItemDecoration


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(zou.yuchen.senegence.R.layout.activity_main)

        val redditPostAdapter = RedditPostAdapter()

        val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)

        val recyclerView = findViewById<RecyclerView>(R.id.post_rv)
        recyclerView.adapter = redditPostAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.addItemDecoration(decoration)

        val model = ViewModelProviders.of(this).get(RedditViewModel::class.java)
        model.getPosts().observe(this, Observer<List<RedditPost>>{ posts -> redditPostAdapter.updatePostList(posts!!)})
    }
}
