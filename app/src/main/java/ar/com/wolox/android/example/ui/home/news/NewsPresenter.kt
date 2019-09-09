package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsServices
import javax.inject.Inject
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter @Inject constructor(private val monitorServices: RetrofitServices) : BasePresenter<NewsView>() {

    override fun onViewAttached() {
        getNews()
    }

    private fun getNews() {
        val call = monitorServices.getService(NewsServices::class.java).getNews()
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showError()
            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                view.showNews(requireNotNull(response.body()))
            }
        })
    }
}
