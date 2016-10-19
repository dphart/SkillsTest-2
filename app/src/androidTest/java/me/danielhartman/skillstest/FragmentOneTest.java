package me.danielhartman.skillstest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import javax.inject.Inject;

import me.danielhartman.skillstest.dagger.DaggerHolder;
import me.danielhartman.skillstest.dagger.DaggerTestAppComponent;
import me.danielhartman.skillstest.dagger.TestAppComponent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FragmentOneTest {
//    @Inject
    FragmentOnePresenter mFragmentOnePresenter;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class, true, false);

    @Before
    public void setup(){
        TestAppComponent testAppComponent = DaggerTestAppComponent.builder().build();
        DaggerHolder.getInstance().setComponent(testAppComponent);
        mFragmentOnePresenter = DaggerHolder.getInstance().component().getFragmentOnePresenter();
    }

    @Test
    public void simpleTest(){
        when(mFragmentOnePresenter.getRandomInt()).thenReturn(5);
        mActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.container)).check(matches(isDisplayed()));
    }

}