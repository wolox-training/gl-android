package ar.com.wolox.android.example.ui.login;


interface LoginView {

    void onLoginSuccess();

    void onEmailFieldEmpty();

    void onPasswordFieldEmpty();

    void onEmailFieldInvalid();
}
