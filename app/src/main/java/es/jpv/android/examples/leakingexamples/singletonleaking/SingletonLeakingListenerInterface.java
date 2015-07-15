package es.jpv.android.examples.leakingexamples.singletonleaking;

import android.app.Notification;
import android.support.v7.app.ActionBarActivity;

public interface SingletonLeakingListenerInterface {
    public void onEvent(boolean response);
    public ActionBarActivity getActivity();
}
