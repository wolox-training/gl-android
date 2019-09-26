package ar.com.wolox.android.examples.ui.home.newDetails

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.examples.R
import ar.com.wolox.android.examples.model.News
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewDetailsActivity : WolmoActivity() {

    override fun layout() = R.layout.activity_news_details

    override fun init() {
        replaceFragment(R.id.vActivityNewsDetails, NewDetailsFragment.newInstance(
                intent.getSerializableExtra(NEWS_ID) as News,
                intent.getSerializableExtra(USER_ID) as Int))
    }

    companion object {

        private const val NEWS_ID = "newsId"
        private const val USER_ID = "userId"

        fun start(context: Context, currentNews: News, user: Int) {
            context.startActivity(Intent(context, NewDetailsActivity::class.java)
                    .putExtra(NEWS_ID, currentNews)
                    .putExtra(USER_ID, user))
        }
    }
}
