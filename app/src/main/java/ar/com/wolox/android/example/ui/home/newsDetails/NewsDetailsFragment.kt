package ar.com.wolox.android.example.ui.home.newsDetails

import android.os.Bundle
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news_details.*
import javax.inject.Inject

class NewsDetailsFragment @Inject constructor() : WolmoFragment<NewsDetailsPresenter>(), NewsDetailsView {

    private lateinit var currentNews: News
    private lateinit var username: String

    override fun layout() = R.layout.fragment_news_details

    override fun init() {
        currentNews = arguments!!.getSerializable(NEWS_ID) as News
        username = arguments!!.getSerializable(USER_ID) as String
        configuratorNews(currentNews, username)
    }

    companion object {
        private val NEWS_ID = "newsKey"
        private val USER_ID = "usersKey"

        fun newInstance(currentNews: News, user: String): NewsDetailsFragment {
            val args = Bundle()
            args.putSerializable(NEWS_ID, currentNews)
            args.putSerializable(USER_ID, user)
            val fragment = NewsDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    // Configuro mi News y seteo los parametros de presentacion
    private fun configuratorNews(currentNews: News, username: String) {

        vNewDetailsTitle.text = currentNews.title
        vNewDetailsTime.text = currentNews.readableCreationTime
        vNewDetailsTextInformation.text = currentNews.text
        Glide.with(requireContext()).load(currentNews.formatPicture).into(vNewsDetailsBackgroundNew)
        if (currentNews.likes.contains(username.toInt()))
            vNewsDetailsEmotionImage.setImageResource(R.drawable.ic_like_on)
        else
            vNewsDetailsEmotionImage.setImageResource(R.drawable.ic_like_off)
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

    override fun setListeners() {
        vNewsDetailsBackButton.setOnClickListener {
            activity?.onBackPressed()
        }

        /**vNewsDetailsSwipeRefreshLayout.setOnRefreshListener {
        presenter.onRefreshNewsDetails(id)

        }
         */
    }

    override fun showNew(body: News) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
