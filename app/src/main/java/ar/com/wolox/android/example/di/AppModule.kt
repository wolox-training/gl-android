package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.android.example.ui.login.LoginFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun loginFragment(): LoginFragment
}