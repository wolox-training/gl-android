package ar.com.wolox.android.example.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {

    protected Intent intent;
    protected SharedPreferences sharedPref;
    protected SharedPreferences.Editor editor;
    protected Class activity;


    @Override
    protected int layout() {
        return R.layout.activity_root;

    }

    @Override
    protected void init() {

        if (OnUsernameLoginSaved())
            activity = HomeActivity.class;
        else
            activity = LoginActivity.class;

        intent = new Intent(this, activity);
        this.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private boolean OnUsernameLoginSaved() {
        return getUsernameLogin() != null;

    }

    private String getUsernameLogin() {
        sharedPref = getSharedPreferences(getApplication().getString(R.string.vlogin_preferences_name), MODE_PRIVATE);
        return sharedPref.getString("username", null);

    }

}