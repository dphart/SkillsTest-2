package me.danielhartman.skillstest.dagger;



import javax.inject.Singleton;

import dagger.Component;
import me.danielhartman.skillstest.FragmentOne;
import me.danielhartman.skillstest.FragmentOneTest;

@Singleton
@Component(modules = {TestAppModule.class})
public interface TestAppComponent extends AppComponentBase{
}
