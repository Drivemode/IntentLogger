package com.drivemode.intentlog.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.drivemode.intentlog.IntentLogger;
import com.drivemode.intentlog.PendingIntentLogger;

/**
 * @author KeishinYokomaku
 */
public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dump intent
        IntentLogger.dump("test", getIntent());

        // dump pending intent
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntentLogger.dump("test", PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT));

        // dump bundle
        Bundle bundle = new Bundle();
        bundle.putString("key", "value");
        Bundle nestedBundle = new Bundle();
        nestedBundle.putString("nested_key", "nested_value");
        bundle.putBundle("nested_bundle", nestedBundle);
        IntentLogger.dumpExtras("test", bundle);
    }
}
