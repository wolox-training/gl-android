package ar.com.wolox.android.example.ui.login;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;


public class LoginActivity extends WolmoActivity {
    @Override
    protected int layout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        //replaceFragment(R.id.vActivityBaseContent, ExampleFragment())
        //vActivity es parte del nombre del id que identifica al mismo, cuando lo cree lo tengo que cambiar
        replaceFragment(R.id.vActivityLogin, new LoginFragment());

    }
}
