package ar.com.wolox.android.example.ui;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return R.layout.activity_root;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.vActivityRoot, new RootFragment());
    }
}
