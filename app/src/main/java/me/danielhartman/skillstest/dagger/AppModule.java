package me.danielhartman.skillstest.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.danielhartman.skillstest.FragmentOnePresenter;


@Module
public class AppModule {

    @Provides
    @Singleton
    FragmentOnePresenter getFragmentOnePresenter(){
        return new FragmentOnePresenter();
    }


}
