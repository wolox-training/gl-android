package ar.com.wolox.android.examples.ui.home.news

import ar.com.wolox.android.examples.model.News

interface NewsView {

    fun showError()

    fun showConnectionError()

    fun showNews(body: List<News>)

    fun showLoading(case: Boolean)

    fun showNewsDetails(new: News, userId: Int?)
}
