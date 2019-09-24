package ar.com.wolox.android.example.ui.home.newDetails

import android.os.Bundle
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.onClickListener
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_news_details.*
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_news_details.vNewsDetailsEmotionImage

class NewDetailsFragment @Inject constructor() : WolmoFragment<NewDetailsPresenter>(), NewDetailsView {

    private lateinit var currentNews: News
    private var username: Int? = null

    override fun layout() = R.layout.fragment_news_details

    override fun init() {
        currentNews = arguments!!.getSerializable(NEWS_ID) as News
        username = arguments!!.getSerializable(USER_ID) as Int
        newsConfigurator(currentNews, username!!)
        presenter.setNewDetailId(currentNews.id)
    }

    companion object {
        private val NEWS_ID = "newsId"
        private val USER_ID = "userId"

        fun newInstance(currentNews: News, user: Int): NewDetailsFragment {
            val args = Bundle()
            args.putSerializable(NEWS_ID, currentNews)
            args.putSerializable(USER_ID, user)
            val fragment = NewDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun newsConfigurator(currentNews: News, username: Int) {
        vNewDetailsTitle.text = currentNews.title
        vNewDetailsTime.text = currentNews.readableCreationTime
        vNewDetailsTextInformation.text = currentNews.text
        Glide.with(requireContext()).load(currentNews.formatPicture).into(vNewsDetailsBackgroundNew)
        vNewsDetailsEmotionImage.setImageResource(R.drawable.ic_like_selector_large)
        vNewsDetailsEmotionImage.isSelected = currentNews.likes.contains(username)
    }

    override fun showLoading(case: Boolean) {
        vNewsDetailsSwipeRefreshLayout.isRefreshing = case
    }

    override fun showError() {
        Toast.makeText(context, R.string.fail_generic, Toast.LENGTH_SHORT).show()
    }

    override fun showConnectionError() {
        Toast.makeText(context, R.string.fail_loading_news, Toast.LENGTH_SHORT).show()
    }

    override fun setListeners() {
        vNewsDetailsSwipeRefreshLayout.setOnRefreshListener {
            presenter.onRefreshNewsDetails()
        }

        vNewsDetailsBackButton.onClickListener {
            requireActivity().onBackPressed()
        }

        vNewsDetailsEmotionImage.onClickListener {
            presenter.changeLikesStatus(username)
        }
    }

    override fun showNewsDetailsToLikesUpdates(likes: ArrayList<Int>) {
        currentNews.likes = likes
        vNewsDetailsEmotionImage.isSelected = currentNews.likes.contains(username)
    }

    override fun showNewsDetails(newDetails: News) {
        newsConfigurator(newDetails, username!!)
    }
}
