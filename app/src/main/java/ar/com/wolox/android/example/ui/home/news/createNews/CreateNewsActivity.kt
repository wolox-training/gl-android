package ar.com.wolox.android.example.ui.home.news.createNews

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class CreateNewsActivity : WolmoActivity() {

    override fun layout(): Int {
        return R.layout.activity_create_news
    }

    override fun init() {
        replaceFragment(R.id.vCreateNewsBaseActivity, CreateNewsFragment())
    }
}