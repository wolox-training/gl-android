package ar.com.wolox.android.example.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Patterns;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private static final String SP_USERNAME_KEY = "username";

    @Inject
    LoginPresenter() {
    }


    @SuppressLint("CommitPrefEdits")
    void setPreferences(Context context, String emailField) {
        sharedPref = context.getSharedPreferences(context.getString(R.string.login_preferences_name), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SP_USERNAME_KEY, emailField);
        editor.apply();
    }

    void doLogin(String emailField, String passwordField) {
        if (validationFields(emailField, passwordField))
            getView().onLoginSuccess();
    }

    private boolean validationFields(String emailField, String passwordField) {
        if (emailField.isEmpty())
            getView().displayEmailFieldEmpty();
        else if (passwordField.isEmpty())
            getView().displayPasswordFieldEmpty();
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailField).matches())
            getView().displayEmailFieldInvalid();
        else
            return true;
        return false;
    }
}
