package zou.yuchen.senegence.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RedditRestClient {
    companion object {
        val redditUrl = "https://www.reddit.com"
        var isInitialized: Boolean = false

        lateinit var redditClient: Retrofit

        fun getRedditApi(): RedditApi {
            if (isInitialized) {
                initRedditClient()
            }

            return redditClient.create(RedditApi::class.java)
        }

        private fun initRedditClient() {
            redditClient = Retrofit.Builder()
                .baseUrl(redditUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            isInitialized = true
        }
    }
}