package ar.com.wolox.android.example.ui.login;


interface LoginView {

    void onLoginSuccess(Integer toInteger);

    void displayEmailFieldEmpty();

    void displayPasswordFieldEmpty();

    void displayEmailFieldInvalid();

    void displayLoginFailure();

    void displayInvalidPassword();

    void displayInvalidEmail();

    void startLoading();

    void completeLoading();

    void displayLogInGoogleError();

    void displayLogInGoogleServerError();

    void displayLogInGoogleNoConnection();
}
