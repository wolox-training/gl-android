package ar.com.wolox.android.example.ui.login;

import android.widget.Button;
import android.widget.EditText;
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
        EditText vEmailAccount = requireActivity().findViewById(R.id.vEmailAccount);
        EditText vPassword = requireActivity().findViewById(R.id.vPassword);
        Button vLogin = requireActivity().findViewById(R.id.vLogInButton);
        Button vSignup = requireActivity().findViewById(R.id.vSignUpButton);

        vLogin.setOnClickListener(view -> {
            if (vEmailAccount.getText().toString().isEmpty() && vPassword.getText().toString().isEmpty())
                Toast.makeText(requireContext(), "Los campos de correo electronico y contraseña se encuentran vacios",Toast.LENGTH_SHORT).show();
            else if (vEmailAccount.getText().toString().isEmpty() )
                Toast.makeText(requireContext(), "Ingrese correo electronico",Toast.LENGTH_SHORT).show();
            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(vEmailAccount.getText().toString()).matches())
                Toast.makeText(requireContext(), "Ingrese correo electronico valido",Toast.LENGTH_SHORT).show();
            else if (vPassword.getText().toString().isEmpty() )
                Toast.makeText(requireContext(), "Ingrese Contraseña valida",Toast.LENGTH_SHORT).show();
            else if (vPassword.getText().toString().length() < 6 )
                Toast.makeText(requireContext(), "La contraseña debe tener mas de 6 caracteres",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(requireContext(), "Login presionado",Toast.LENGTH_SHORT).show();
        });

        vSignup.setOnClickListener(view -> {
            Toast.makeText(requireContext(), "Signup presionado",Toast.LENGTH_SHORT).show();
        });
    }

}
