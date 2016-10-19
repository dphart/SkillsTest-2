package me.danielhartman.skillstest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onPause() {
        getPresenter().onPause();
        super.onPause();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initDagger();
        super.onCreate(savedInstanceState);
    }

    protected abstract void initDagger();

    public abstract Presenter getPresenter();

    abstract void presentViews();
}
