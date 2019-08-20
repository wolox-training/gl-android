package ar.com.wolox.android.example.ui.home;

import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class HomeFragment extends WolmoFragment<HomePresenter> implements HomeView {

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        return true;
    }

}
