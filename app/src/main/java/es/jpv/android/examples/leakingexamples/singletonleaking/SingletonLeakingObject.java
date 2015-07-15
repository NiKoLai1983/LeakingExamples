package es.jpv.android.examples.leakingexamples.singletonleaking;

public class SingletonLeakingObject {

    private SingletonLeakingListenerInterface listener;

    public SingletonLeakingListenerInterface getListener() {
        return listener;
    }

    public void setListener(SingletonLeakingListenerInterface listener) {
        this.listener = listener;
    }

    public void triggerEvent(boolean value) {
        listener.onEvent(value);
    }

}
