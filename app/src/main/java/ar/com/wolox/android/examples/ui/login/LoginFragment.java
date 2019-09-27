package ar.com.wolox.android.examples.ui.login;

import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

import java.util.Objects;

import ar.com.wolox.android.examples.R;
import ar.com.wolox.android.examples.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    @BindView(R.id.vLogInButton) Button vLogInButton;
    @BindView(R.id.vSignUpButtonGoogle) SignInButton vSignUpButtonGoogle;
    @BindView(R.id.vLogInEmail) EditText vLogInEmail;
    @BindView(R.id.vLogInPassword) EditText vLogInPassword;
    @BindView(R.id.vTermsConditions) TextView vTermsConditions;
    @BindView(R.id.vLoginProgressBar) ProgressBar vLoginProgressBar;

    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN = 0;

    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        ButterKnife.bind(this, Objects.requireNonNull(getActivity()));
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            if (getPresenter().signInGoogle(getPresenter().getTask(data), getContext())) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }
    }

    @Override
    public void setListeners() {
        vLogInButton.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                getPresenter().doLogin(vLogInEmail.getText().toString(), vLogInPassword.getText().toString());
            }
        });

        vSignUpButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @OnClick
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
        vTermsConditions.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void displayLogInGoogleError() {
        Toast.makeText(requireContext(), R.string.login_invalid_user, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayLogInGoogleServerError() {
        Toast.makeText(requireContext(), R.string.login_server_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayLogInGoogleNoConnection() {
        Toast.makeText(requireContext(), R.string.login_failed, Toast.LENGTH_SHORT).show();
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
    public void onLoginSuccess(Integer userId) {
        getPresenter().setPreferences(Objects.requireNonNull(getContext()), vLogInEmail.getText().toString(), userId);
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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
