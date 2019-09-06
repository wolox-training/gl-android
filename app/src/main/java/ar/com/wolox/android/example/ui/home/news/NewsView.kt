package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News

interface NewsView {

    // fun goAddNews()

    // fun nothingNewToShow()

    fun showError()

    fun showNews(body: List<News>)
}
