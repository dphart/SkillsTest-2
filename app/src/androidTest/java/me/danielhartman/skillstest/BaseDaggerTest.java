package me.danielhartman.skillstest;


import org.junit.Before;

import me.danielhartman.skillstest.dagger.AppComponent;
import me.danielhartman.skillstest.dagger.TestAppComponent;

public abstract class BaseDaggerTest {

    public AppComponent testAppComponent;

    @Before
    public void setup(){
        initDagger();
    }

//     public TestAppComponent getTestAppComponent(){
//
//     }

    public abstract void initDagger();




}
