package es.jpv.android.examples.leakingexamples.singletonleaking;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MySingleton
{
    private static MySingleton instance;

    public List<SingletonLeakingObject> objectList = new ArrayList<SingletonLeakingObject>();

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

    public void add(SingletonLeakingObject object)
    {
        // You are now storing an instance of an anonymous inner class implementing
        // SingletonLeakingListenerInterface and created into SingletonLeakingActivity.
        // Therefore, the SingletonLeakingActivity instance is also leaked into the
        // singleton, leading to it to be not garbage-collected
        objectList.add(object);
    }

    /**
     * We search the instance of SingletonLeakingObject inside the singleton using
     * the SingletonLeakingActivity instance we are destroying as a reference.
     * We remove the SingletonLeakingObject from the list to avoid leaking the activity
     *
     * @param activity
     */
    public void delete(ActionBarActivity activity) {
        SingletonLeakingObject objectToRemove = null;

        for (SingletonLeakingObject object : objectList) {
            if (object.getListener().getActivity() == activity) {
                objectToRemove = object;
                break;
            }
        }
        if (objectToRemove != null) {
            objectList.remove(objectToRemove);
        }
    }
}
