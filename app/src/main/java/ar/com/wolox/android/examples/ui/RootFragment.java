package ar.com.wolox.android.examples.ui;

import android.content.Intent;
import java.util.Objects;
import ar.com.wolox.android.examples.R;
import ar.com.wolox.android.examples.ui.home.HomeActivity;
import ar.com.wolox.android.examples.ui.login.LoginActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class RootFragment extends WolmoFragment<RootPresenter> implements RootView {

    protected Class activity;

    @Override
    public int layout() {
        return R.layout.fragment_root;
    }

    @Override
    public void init() {
        if (getPresenter().isUsernameSaved(Objects.requireNonNull(getContext())))
            activity = HomeActivity.class;
        else activity = LoginActivity.class;
        Intent intent = new Intent(getContext(), activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
