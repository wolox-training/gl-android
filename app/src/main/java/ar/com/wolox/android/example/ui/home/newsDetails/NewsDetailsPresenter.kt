package ar.com.wolox.android.example.ui.home.newsDetails

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsServices
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsDetailsPresenter @Inject constructor(private val monitorServices: RetrofitServices) : BasePresenter<NewsDetailsView>() {

    private lateinit var newDetails: News

    private var isLoading: Boolean = true
        set(value) {
            field = value
            view.showLoading(value)
        }

    fun onRefreshNewsDetails(id: Int) {
        isLoading = true
        getNew(id)
    }

    private fun getNew(id: Int) {
        isLoading = true

        val call = monitorServices.getService(NewsServices::class.java).getNewsDetails(id)
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showError()
                isLoading = false
            }

            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                newDetails = requireNotNull(response.body())[0]
                view.showNew(newDetails)
                isLoading = false
            }
        })
    }
}
