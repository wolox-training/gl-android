package ar.com.wolox.android.example.ui.home.news

import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.home.newDetails.NewDetailsActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsPresenter>(), NewsView {

    private var vHomeListItems = arrayListOf<News>()
    private lateinit var vAdapter: NewsAdapter
    private lateinit var vLayoutManager: LinearLayoutManager

    override fun layout() = R.layout.fragment_news

    override fun init() {

        vLayoutManager = LinearLayoutManager(requireContext())
        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        vNewsRecyclerView.setHasFixedSize(true)
        vNewsRecyclerView.addItemDecoration(DividerItemDecoration(vNewsRecyclerView.context, vLayoutManager.orientation))
        vNewsRecyclerView.layoutManager = vLayoutManager
    }

    override fun showLoading(case: Boolean) {
        vNewsSwipeRefreshLayout.isRefreshing = case
    }

    override fun showError() {
        Toast.makeText(context, R.string.fail_generic, Toast.LENGTH_SHORT).show()
    }

    override fun showConnectionError() {
        Toast.makeText(context, R.string.fail_loading_news, Toast.LENGTH_SHORT).show()
    }

    override fun showNews(body: List<News>) {
        vHomeListItems = ArrayList(body)
        vAdapter = NewsAdapter(vHomeListItems, presenter.getUserId(requireContext())) {
            presenter.onNewsClicked(it)
        }
        vNewsRecyclerView.adapter = vAdapter
        vAdapter.notifyDataSetChanged()
    }

    override fun setListeners() {
        vNewsSwipeRefreshLayout.setOnRefreshListener {
            presenter.onRefreshNews()
        }

        vNewsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val totalItemCount = vLayoutManager.itemCount
                val lastVisibleItemPosition = vLayoutManager.findLastVisibleItemPosition()
                if (lastVisibleItemPosition + 1 >= totalItemCount) {
                    presenter.getAddedNews()
                }
            }
        })
    }

    override fun showNewsDetails(new: News, userId: Int?) {
        NewDetailsActivity.start(requireContext(), new, userId!!)
    }
}