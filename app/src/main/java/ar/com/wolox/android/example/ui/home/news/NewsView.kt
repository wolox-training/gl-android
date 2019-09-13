package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News

interface NewsView {

    fun showError()

    fun showConnectionError()

    fun showNews(body: List<News>)

    fun showLoading(case: Boolean)
}
