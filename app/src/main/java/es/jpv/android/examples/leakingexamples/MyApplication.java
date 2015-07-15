package es.jpv.android.examples.leakingexamples;

import android.app.Application;

import es.jpv.android.examples.leakingexamples.singletonleaking.MySingleton;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        // Initialize the singletons so their instances
        // are bound to the application process.
        initSingletons();
    }

    protected void initSingletons()
    {
        // Initialize the instance of MySingleton
        MySingleton.initInstance();
    }

}
