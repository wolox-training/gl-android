package ar.com.wolox.android.example.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Patterns;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import ar.com.wolox.android.R;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.LoginService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter extends BasePresenter<LoginView> {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    private static final String SP_USERNAME_KEY = "username";
    private static final String USER_ID = "userId";

    @Inject
    RetrofitServices monitorServices;

    @Inject
    LoginPresenter() {
    }

    @SuppressLint("CommitPrefEdits")
    void setPreferences(Context context, String emailField, Integer userId) {
        sharedPref = context.getSharedPreferences(context.getString(R.string.login_preferences_name), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        editor.putString(SP_USERNAME_KEY, emailField);
        editor.putInt(USER_ID, userId);
        editor.apply();
    }

    void doLogin(String emailField, String passwordField) {
        getView().startLoading();
        if (validationFields(emailField, passwordField)) {
            Call<List<User>> call = monitorServices.getService(LoginService.class).getUserLogin(emailField);
            call.enqueue(new Callback<List<User>>() {

                @Override
                public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                    getView().completeLoading();
                    onResponseValidation(response, passwordField);
                }

                @Override
                public void onFailure(@NotNull Call<List<User>> call, @NotNull Throwable t) {
                    getView().completeLoading();
                    getView().displayLoginFailure();
                }
            });
        }
    }

    private void onResponseValidation(Response<List<User>> response, String passwordField) {
        if (Objects.requireNonNull(response.body()).isEmpty()) {
            getView().displayInvalidEmail();
        } else if (!response.body().get(0).getPassword().equals(passwordField)) {
            getView().displayInvalidPassword();
        } else {
            getView().onLoginSuccess(response.body().get(0).getId());
        }
    }



    private boolean validationFields(String emailField, String passwordField) {
        if (emailField.isEmpty())
            getView().displayEmailFieldEmpty();
        else if (passwordField.isEmpty())
            getView().displayPasswordFieldEmpty();
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailField).matches())
            getView().displayEmailFieldInvalid();
        else
            return true;
        return false;
    }
}
