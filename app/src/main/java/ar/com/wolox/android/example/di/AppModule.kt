package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.ui.RootActivity
import ar.com.wolox.android.example.ui.RootFragment
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.home.HomeFragment
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.android.example.ui.login.LoginFragment
import ar.com.wolox.android.example.ui.signup.SignUpActivity
import ar.com.wolox.android.example.ui.signup.SignUpFragment

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
