package me.danielhartman.skillstest.dagger;


import android.support.v4.app.Fragment;

import me.danielhartman.skillstest.FragmentOne;
import me.danielhartman.skillstest.FragmentOnePresenter;

public interface AppComponentBase {
    FragmentOnePresenter getFragmentOnePresenter();
}
