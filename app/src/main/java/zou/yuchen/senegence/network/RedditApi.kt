package zou.yuchen.senegence.network

import io.reactivex.Observable
import retrofit2.http.GET
import zou.yuchen.senegence.model.RedditDataContainer

interface RedditApi {
    @GET("/r/bmw/top.json?limit=100")
    fun getTopPosts(): Observable<RedditDataContainer>
}