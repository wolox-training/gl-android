package ar.com.wolox.android.examples.di

import ar.com.wolox.android.examples.ui.RootActivity
import ar.com.wolox.android.examples.ui.RootFragment
import ar.com.wolox.android.examples.ui.home.HomeActivity
import ar.com.wolox.android.examples.ui.home.HomeFragment
import ar.com.wolox.android.examples.ui.home.news.NewsFragment
import ar.com.wolox.android.examples.ui.home.newDetails.NewDetailsActivity
import ar.com.wolox.android.examples.ui.home.newDetails.NewDetailsFragment
import ar.com.wolox.android.examples.ui.home.profile.ProfileFragment
import ar.com.wolox.android.examples.ui.login.LoginActivity
import ar.com.wolox.android.examples.ui.login.LoginFragment
import ar.com.wolox.android.examples.ui.signup.SignUpActivity
import ar.com.wolox.android.examples.ui.signup.SignUpFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector
    internal abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun newsFragment(): NewsFragment

    @ContributesAndroidInjector
    internal abstract fun newsDetailsActivity(): NewDetailsActivity

    @ContributesAndroidInjector
    internal abstract fun newsDetailsFragment(): NewDetailsFragment

    @ContributesAndroidInjector
    internal abstract fun profileFragment(): ProfileFragment

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun rootFragment(): RootFragment

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun loginFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun signupActivity(): SignUpActivity

    @ContributesAndroidInjector
    internal abstract fun signupFragment(): SignUpFragment
}