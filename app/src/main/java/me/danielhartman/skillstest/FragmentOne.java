package me.danielhartman.skillstest;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import me.danielhartman.skillstest.dagger.DaggerHolder;
import me.danielhartman.skillstest.databinding.FragmentOneLayoutBinding;

public class FragmentOne extends BaseFragment {

//    @Inject
    FragmentOnePresenter presenter;

    FragmentOneLayoutBinding binding;

    @Override
    protected void initDagger() {
        presenter = DaggerHolder.getInstance().component().getFragmentOnePresenter();
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    void presentViews() {
        presenter.present(binding);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_one_layout,container,false);
        presentViews();
        return binding.getRoot();
    }
}
