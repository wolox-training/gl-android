package ar.com.wolox.android.example.ui.login;

import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signup.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.BindView;



public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    @BindView(R.id.vLogInButton) Button vLogInButton;
    @BindView(R.id.vSignUpButton) Button vSignUpButton;
    @BindView(R.id.vLogInEmail) EditText vLogInEmail;
    @BindView(R.id.vLogInPassword) EditText vLogInPassword;
    @BindView(R.id.vTermsConditions) TextView vTermsConditions;
    @BindView(R.id.vLoginProgressBar) ProgressBar vLoginProgressBar;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        ButterKnife.bind(this, Objects.requireNonNull(getActivity()));
    }

    @Override
    public void setListeners() {
        vLogInButton.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                getPresenter().doLogin(vLogInEmail.getText().toString(), vLogInPassword.getText().toString());
            }
        });

        vSignUpButton.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
            }
        });
        vTermsConditions.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void displayLoginFailure() {
        Toast.makeText(requireContext(), R.string.login_failed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayInvalidPassword() {
        Toast.makeText(requireContext(), R.string.login_invalid_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayInvalidEmail() {
        Toast.makeText(requireContext(), R.string.login_invalid_user, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        getPresenter().setPreferences(Objects.requireNonNull(getContext()), vLogInEmail.getText().toString());
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayEmailFieldEmpty() {
        vLogInEmail.setError(getString(R.string.login_empty_email));
    }

    @Override
    public void displayPasswordFieldEmpty() {
        vLogInPassword.setError(getString(R.string.login_empty_password));
    }

    @Override
    public void displayEmailFieldInvalid() {
        vLogInEmail.setError(getString(R.string.login_invalid_email));
    }

    @Override
    public void startLoading() {
        vLoginProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void completeLoading() {
        vLoginProgressBar.setVisibility(View.INVISIBLE);
    }
}
