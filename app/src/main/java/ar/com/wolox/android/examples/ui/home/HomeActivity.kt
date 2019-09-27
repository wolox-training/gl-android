package ar.com.wolox.android.examples.ui.home

import ar.com.wolox.android.examples.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class HomeActivity : WolmoActivity() {

    override fun layout(): Int {
        return R.layout.activity_home
    }

    override fun init() {
        replaceFragment(R.id.vActivityHome, HomeFragment())
    }
}