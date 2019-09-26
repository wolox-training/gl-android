package ar.com.wolox.android.examples.ui.signup;

import ar.com.wolox.android.examples.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class SignUpActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return R.layout.activity_signup;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.vActivitySignUp, new SignUpFragment());
    }
}