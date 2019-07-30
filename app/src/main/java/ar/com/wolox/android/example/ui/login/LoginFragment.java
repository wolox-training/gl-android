package ar.com.wolox.android.example.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class LoginFragment extends WolmoFragment<LoginPresenter> implements LoginView {

    //    override fun layout(): Int = R.layout.fragment_example
    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        Button vLogin = requireActivity().findViewById(R.id.vLogInButton);
        vLogin.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "Login pressed",Toast.LENGTH_SHORT).show();
        });
        Button vSignup = requireActivity().findViewById(R.id.vSignUpButton);
        vSignup.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "Signup pressed",Toast.LENGTH_SHORT).show();
        });
    }
}

