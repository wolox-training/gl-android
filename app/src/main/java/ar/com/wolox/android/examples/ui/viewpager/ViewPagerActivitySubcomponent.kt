package ar.com.wolox.android.examples.ui.viewpager

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface ViewPagerActivitySubcomponent : AndroidInjector<ViewPagerActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ViewPagerActivity>()
}
