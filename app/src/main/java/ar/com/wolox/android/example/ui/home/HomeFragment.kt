package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.core.util.Pair
import javax.inject.Inject

class HomeFragment : WolmoFragment<HomePresenter>(), HomeView {

    @Inject internal lateinit var mPageNews: NewsFragment
    @Inject internal lateinit var mPageProfile: ProfileFragment
    private lateinit var mFragmentHomePagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    override fun init() {
        vTabFragmentHome.setupWithViewPager(vViewPagerFragmentHome)

        mFragmentHomePagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager).apply {
            addFragments(
                    Pair(mPageNews, "News"),
                    Pair(mPageProfile, "Profile")
            )
        }

        vViewPagerFragmentHome.apply {
            adapter = mFragmentHomePagerAdapter
            addOnPageChangeListener(
                    TabLayout.TabLayoutOnPageChangeListener(vTabFragmentHome)
            )
        }

        onTabInit()
    }

    private fun onTabInit() {
        vTabFragmentHome.run {
            getTabAt(0)!!.setIcon(R.drawable.ic_news_selected)
            getTabAt(1)!!.setIcon(R.drawable.ic_profile_selected)
        }
    }
}
