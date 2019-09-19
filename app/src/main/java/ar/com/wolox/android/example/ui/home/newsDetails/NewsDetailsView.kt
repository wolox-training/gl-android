package ar.com.wolox.android.example.ui.home.newsDetails

import ar.com.wolox.android.example.model.News

interface NewsDetailsView {

    fun showLoading(case: Boolean)

    fun showError()

    fun showConnectionError()

    fun showNew(body: News)
}
