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
        IntentLogger.dump("test", getIntent());
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntentLogger.dump("test", PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
