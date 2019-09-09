package ar.com.wolox.android.example.ui.home.news

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private var vHomeListItems = arrayListOf<News>()
    private lateinit var vAdapter: NewsAdapter

    override fun showError() {
    }

    override fun showNews(body: List<News>) {

        // Added sample data to test the view from Heroku
        vHomeListItems = ArrayList(body)
        vHomeListItems.addAll(vHomeListItems)
        vHomeListItems.addAll(vHomeListItems)
        vHomeListItems.addAll(vHomeListItems)

        vAdapter = NewsAdapter(vHomeListItems)
        vNewsRecyclerView.adapter = vAdapter
        val vLayoutManager = LinearLayoutManager(requireContext())
        vNewsRecyclerView.layoutManager = vLayoutManager
        vNewsRecyclerView.addItemDecoration(DividerItemDecoration(vNewsRecyclerView.context, vLayoutManager.orientation))
    }

    override fun layout() = R.layout.fragment_news

    override fun init() {
    }

    override fun onBackPressed(): Boolean {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
        return true
    }
}