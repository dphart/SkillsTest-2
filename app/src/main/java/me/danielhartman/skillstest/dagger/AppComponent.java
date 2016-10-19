package me.danielhartman.skillstest.dagger;



import javax.inject.Singleton;

import dagger.Component;
import me.danielhartman.skillstest.FragmentOne;
import me.danielhartman.skillstest.FragmentOnePresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent extends AppComponentBase{

}
