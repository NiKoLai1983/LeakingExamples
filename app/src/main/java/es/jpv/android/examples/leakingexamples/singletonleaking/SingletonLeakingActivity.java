package es.jpv.android.examples.leakingexamples.singletonleaking;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import es.jpv.android.examples.leakingexamples.MyApplication;
import es.jpv.android.examples.leakingexamples.R;


public class SingletonLeakingActivity extends ActionBarActivity {

    protected MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_leaking);

        // Get the application instance
        app = (MyApplication)getApplication();

        SingletonLeakingObject leakingObject = new SingletonLeakingObject();
        // Now you're creating an anonymous inner class implementing SingletonLeakingListenerInterface
        // and contained inside this instance of SingletonLeakingActivity.
        // If you store an instance of this class somewhere, this activity is also leaked there.
        leakingObject.setListener(new SingletonLeakingListenerInterface() {
            @Override
            public void onEvent(boolean response) {
                Log.d("Leaking Activity", "Value? " + response);
            }
        });
        // Insert the object inside the singleton. The activity is leaked in there
        MySingleton.getInstance().add(leakingObject);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_singleton_leaking, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
