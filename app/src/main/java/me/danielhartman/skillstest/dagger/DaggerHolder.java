package me.danielhartman.skillstest.dagger;


public class DaggerHolder {
    private static DaggerHolder sInstance = new DaggerHolder();
    private AppComponentBase mComponent;
    public static DaggerHolder getInstance() {
        return sInstance;
    }
    private DaggerHolder() {
    }
    public void setComponent(AppComponentBase component) {
        mComponent = component;
    }
    public AppComponentBase component() {
        return mComponent;
    }
}
