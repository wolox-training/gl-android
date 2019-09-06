package ar.com.wolox.android.example.ui.home.news.createNews

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class CreateNewsFragment : WolmoFragment<CreateNewsPresenter>(), CreateNewsView {

    override fun layout(): Int {
        return R.layout.fragment_create_news
    }

    override fun init() {
        // vToolbarNewsCreation.setNewsCreationTitle()
    }
}