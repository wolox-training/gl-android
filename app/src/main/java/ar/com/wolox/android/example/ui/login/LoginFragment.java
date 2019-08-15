package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.BindView;


public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    @BindView(R.id.vLogInButton) Button vLogInButton;
    @BindView(R.id.vSignUpButton) Button vSignUpButton;
    @BindView(R.id.vLogInEmail) EditText vLogInEmail;
    @BindView(R.id.vLogInPassword) EditText vLogInPassword;

    @Override
    public int layout() {

        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        ButterKnife.bind(this, getActivity());
    }

    @Override
    public void setListeners() {
        vLogInButton.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                if (getPresenter().ValidationFields(vLogInEmail.getText().toString(), vLogInPassword.getText().toString()))
                    getPresenter().doLogin(vLogInEmail.getText().toString(), vLogInPassword.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        getPresenter().setPreferences(getContext(), vLogInEmail.getText().toString());
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onEmailFieldEmpty() {
        Toast.makeText(requireContext(), R.string.login_empty_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordFieldEmpty() {
        Toast.makeText(requireContext(), R.string.login_empty_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailFieldInvalid() {
        vLogInEmail.setError(getString(R.string.login_invalid_email));
    }

}
