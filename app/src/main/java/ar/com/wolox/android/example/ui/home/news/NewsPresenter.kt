package ar.com.wolox.android.example.ui.home.news

import android.content.Context
import android.content.SharedPreferences
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsServices
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val monitorServices: RetrofitServices, private val userSession: UserSession) : BasePresenter<NewsView>() {

    private lateinit var sharedPref: SharedPreferences
    private val USER_ID = "userId"
    private var listNews = arrayListOf<News>()
    private var isLoading: Boolean = true
        set(value) {
            field = value
            view.showLoading(value)
        }

    override fun onViewAttached() {
        isLoading = true
        getNews()
    }

    private fun getNews() {

        val call = monitorServices.getService(NewsServices::class.java).getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showConnectionError()
                isLoading = false
            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                listNews.addAll(requireNotNull(response.body()))
                listNews = (listNews + listNews + listNews) as ArrayList<News>
                view.showNews(listNews)
                isLoading = false
            }
        })
    }

    fun onRefreshNews() {
        isLoading = true
        getNews()
    }

    fun getAddedNews() {
        isLoading = true

        val call = monitorServices.getService(NewsServices::class.java).getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showConnectionError()
                isLoading = false
            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                listNews.addAll(requireNotNull(response.body()))
                view.showNews(listNews)
                isLoading = false
            }
        })
    }

    internal fun getUserId(context: Context): Int {
        sharedPref = context.getSharedPreferences(context.getString(R.string.login_preferences_name), Context.MODE_PRIVATE)
        return sharedPref.getInt(USER_ID, 0)
    }

    fun onNewsClicked(new: News) {
        view.showNewsDetails(new, sharedPref.getInt(USER_ID, 0))
    }
}