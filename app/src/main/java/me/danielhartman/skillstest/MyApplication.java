package me.danielhartman.skillstest;


import android.app.Application;

import me.danielhartman.skillstest.dagger.AppComponent;
import me.danielhartman.skillstest.dagger.AppComponentBase;
import me.danielhartman.skillstest.dagger.DaggerAppComponent;
import me.danielhartman.skillstest.dagger.DaggerHolder;

public class MyApplication extends Application {

    AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder().build();
        if (DaggerHolder.getInstance().component()==null) {
            DaggerHolder.getInstance().setComponent(mComponent);
        }
    }
}
