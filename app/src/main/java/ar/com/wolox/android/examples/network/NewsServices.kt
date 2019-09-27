package ar.com.wolox.android.examples.network

import ar.com.wolox.android.examples.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("news/")
    fun getNews(): Call<List<News>>

    @GET("/news")
    fun getNewsDetails(@Query("id") newsDetailsId: Int): Call<List<News>>
}