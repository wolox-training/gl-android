package ar.com.wolox.android.examples.ui.home.newDetails

import ar.com.wolox.android.examples.model.News

interface NewDetailsView {

    fun showLoading(case: Boolean)

    fun showError()

    fun showConnectionError()

    fun showNewsDetails(newDetails: News)

    fun showNewsDetailsToLikesUpdates(likes: ArrayList<Int>)
}
