package com.drivemode.intentlog.app;

import android.app.Activity;
import android.os.Bundle;

import com.drivemode.intentlog.IntentLogger;

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
    }
}
