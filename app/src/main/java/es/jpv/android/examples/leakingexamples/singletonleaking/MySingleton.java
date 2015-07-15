package es.jpv.android.examples.leakingexamples.singletonleaking;

import java.util.ArrayList;
import java.util.List;

public class MySingleton
{
    private static MySingleton instance;

    public List<Object> objectList = new ArrayList<Object>();

    public static void initInstance()
    {
        if (instance == null)
        {
            // Create the instance
            instance = new MySingleton();
        }
    }

    public static MySingleton getInstance()
    {
        // Return the instance
        return instance;
    }

    private MySingleton()
    {
        // Constructor hidden because this is a singleton
    }

    public MySingleton getSingleton()
    {
        return instance;
    }

    public void add(Object object)
    {
        // You are now storing an instance of an anonymous inner class implementing
        // SingletonLeakingListenerInterface and created into SingletonLeakingActivity.
        // Therefore, the SingletonLeakingActivity instance is also leaked into the
        // singleton, leading to it to be not garbage-collected
        objectList.add(object);
    }
}
