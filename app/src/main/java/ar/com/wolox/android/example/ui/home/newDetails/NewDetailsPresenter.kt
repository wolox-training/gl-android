package ar.com.wolox.android.example.ui.home.newDetails

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsServices
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewDetailsPresenter @Inject constructor(private val monitorServices: RetrofitServices) : BasePresenter<NewDetailsView>() {

    private var newId: Int = 0
    private var isLoading: Boolean = true
        set(value) {
            field = value
            view.showLoading(value)
        }

    fun setNewDetailId(id: Int) {
        newId = id
    }

    fun changeLikesStatus(username: Int?) {
        isLoading = true

        val call = monitorServices.getService(NewsServices::class.java).getNewsDetails(newId)
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showConnectionError()
                isLoading = false
            }
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {

                // Simulated Post like change
                val new = response.body()!!.first()
                val position = new.likes.indexOf(username)
                if (position == -1)
                    new.likes.add(username!!)
                else
                    new.likes.removeAt(position)
                // Update view from simulated change

                view.showNewsDetailsToLikesUpdates(response.body()!!.first().likes)
                isLoading = false
            }
        })
    }

    fun onRefreshNewsDetails() {
            isLoading = true
            getNewDetails()
    }

    private fun getNewDetails() {
        val call = monitorServices.getService(NewsServices::class.java).getNewsDetails(newId)
        call.enqueue(object : Callback<List<News>> {
            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                view.showConnectionError()
                isLoading = false
            }
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                view.showNewsDetails(requireNotNull(response.body()!!.first()))
                isLoading = false
            }
        })
    }
}
