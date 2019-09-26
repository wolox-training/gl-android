package ar.com.wolox.android.example.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.Patterns;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

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
    private GoogleSignInAccount account;
    private Task<GoogleSignInAccount> task;

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

    Task<GoogleSignInAccount> getTask(Intent intent){
        task = GoogleSignIn.getSignedInAccountFromIntent(intent);
        return task;
    }
    boolean signInGoogle(Task<GoogleSignInAccount> task, Context context){
        getView().startLoading();
        try {
            account = task.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            assert account != null;
            editor = sharedPref.edit();
            editor.putString(SP_USERNAME_KEY, account.getEmail());
            editor.putInt(USER_ID, 0);
            editor.apply();
            return true;
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            e.printStackTrace();
            getView().completeLoading();
            switch (e.getStatusCode()){
                case 5:
                    getView().displayLogInGoogleError();
                    break;
                case 7:
                    getView().displayLogInGoogleNoConnection();
                    break;
                case 8:
                    getView().displayLogInGoogleServerError();
                    break;
            }
            return false;
        }
    }
}
