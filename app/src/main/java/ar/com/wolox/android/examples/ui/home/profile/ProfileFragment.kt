package ar.com.wolox.android.examples.ui.home.profile

import ar.com.wolox.android.examples.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class ProfileFragment @Inject constructor() : WolmoFragment<ProfilePresenter>(), ProfileView {

    override fun layout(): Int {
        return R.layout.fragment_profile
    }

    override fun init() {
    }
}