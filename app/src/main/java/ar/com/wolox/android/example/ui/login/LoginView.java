package ar.com.wolox.android.example.ui.login;


interface LoginView {

    void onLoginSuccess();

    void displayEmailFieldEmpty();

    void displayPasswordFieldEmpty();

    void displayEmailFieldInvalid();

    void displayLoginFailure();

    void displayInvalidPassword();

}
