package me.danielhartman.skillstest.dagger;

import org.mockito.Mockito;
import org.mockito.Spy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.danielhartman.skillstest.FragmentOnePresenter;

@Module
public class TestAppModule  {

    @Provides
    @Singleton
    FragmentOnePresenter getFragmentOnePresenter(){
        return Mockito.spy(new FragmentOnePresenter());
    }


}
