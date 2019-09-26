package ar.com.wolox.android.examples.ui;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;
import ar.com.wolox.android.examples.R;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

public class RootPresenter extends BasePresenter<RootView> {

    private static final String SP_USERNAME_KEY = "username";

    @Inject
    RootPresenter() {
    }

    boolean isUsernameSaved(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.login_preferences_name), Context.MODE_PRIVATE);
        return sharedPref.getString(SP_USERNAME_KEY, null) != null;
    }
}

