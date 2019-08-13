package ar.com.wolox.android.example.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ar.com.wolox.android.R;
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
                if (vLogInEmail.getText().toString().isEmpty() && vLogInPassword.getText().toString().isEmpty())
                    Toast.makeText(requireContext(), "Los campos de correo electronico y contraseña se encuentran vacios", Toast.LENGTH_SHORT).show();
                else if (vLogInEmail.getText().toString().isEmpty())
                    Toast.makeText(requireContext(), "Ingrese correo electronico", Toast.LENGTH_SHORT).show();
                else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(vLogInEmail.getText().toString()).matches())
                    Toast.makeText(requireContext(), "Ingrese correo electronico valido", Toast.LENGTH_SHORT).show();
                else if (vLogInPassword.getText().toString().isEmpty())
                    Toast.makeText(requireContext(), "Ingrese Contraseña valida", Toast.LENGTH_SHORT).show();
                else if (vLogInPassword.getText().toString().length() < 6)
                    Toast.makeText(requireContext(), "La contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(requireContext(), "Login presionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
