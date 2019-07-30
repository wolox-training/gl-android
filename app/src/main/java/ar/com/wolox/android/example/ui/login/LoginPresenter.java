package ar.com.wolox.android.example.ui.login;


//class ExamplePresenter @Inject constructor(private val mUserSession: UserSession) : BasePresenter<IExampleView>() {

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;


public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    LoginPresenter(){}
}


