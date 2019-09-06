package ar.com.wolox.android.example.ui.home

import androidx.core.util.Pair
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : WolmoFragment<HomePresenter>(), HomeView {

    @Inject internal lateinit var pageNews: NewsFragment
    @Inject internal lateinit var pageProfile: ProfileFragment
    private lateinit var fragmentHomePagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int {
        return R.layout.fragment_home
    }

    override fun init() {
        vHomeTabLayout.setupWithViewPager(vHomeViewPager)

        fragmentHomePagerAdapter = SimpleFragmentPagerAdapter(childFragmentManager).apply {
            addFragments(
                    Pair(pageNews, getString(R.string.home_news_fragment)),
                    Pair(pageProfile, getString(R.string.hhome_profile_fragment))
            )
        }

        vHomeViewPager.apply {
            adapter = fragmentHomePagerAdapter
            addOnPageChangeListener(
                    TabLayout.TabLayoutOnPageChangeListener(vHomeTabLayout)
            )
        }
        onTabInit()
    }

    private fun onTabInit() {
        vHomeTabLayout.run {
            getTabAt(0)!!.setIcon(R.drawable.ic_news_selected)
            getTabAt(1)!!.setIcon(R.drawable.ic_profile_selected)
        }
    }
}
