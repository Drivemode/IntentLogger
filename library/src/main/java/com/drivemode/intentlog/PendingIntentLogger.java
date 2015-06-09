package com.drivemode.intentlog;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author KeishinYokomaku
 */
public class PendingIntentLogger {
    private static final HashMap<Integer, String> FLAGS = new HashMap<>();

    static {
        FLAGS.put(PendingIntent.FLAG_CANCEL_CURRENT, "FLAG_CANCEL_CURRENT");
        FLAGS.put(PendingIntent.FLAG_NO_CREATE, "FLAG_NO_CREATE");
        FLAGS.put(PendingIntent.FLAG_ONE_SHOT, "FLAG_ONE_SHOT");
        FLAGS.put(PendingIntent.FLAG_UPDATE_CURRENT, "FLAG_UPDATE_CURRENT");
    }

    /**
     * Conceal ctor to avoid creating instance.
     */
    private PendingIntentLogger() {
        throw new AssertionError();
    }

    public static void dump(String tag, PendingIntent intent) {
        if (intent == null) {
            Log.v(tag, "no pending intent found");
            return;
        }
        Log.v(tag, "PendingIntent[@" + Integer.toHexString(intent.hashCode()) + "] content:");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            dumpJellyBeanMr1(tag, intent);
        } else {
            dumpDefault(tag, intent);
        }
    }

    public static void dumpContentIntent(String tag, PendingIntent intent) {
        try {
            Method getIntent = intent.getClass().getDeclaredMethod("getIntent", null);
            getIntent.setAccessible(true);
            Intent content = (Intent) getIntent.invoke(intent, null);
            IntentLogger.dump(tag, content);
        } catch (NoSuchMethodException e) {
            Log.e(tag, "", e);
        } catch (InvocationTargetException e) {
            Log.e(tag, "", e);
        } catch (IllegalAccessException e) {
            Log.e(tag, "", e);
        }
    }

    public static void dumpTag(String tag, PendingIntent intent) {
        try {
            Method getIntent = intent.getClass().getDeclaredMethod("getTag", String.class);
            getIntent.setAccessible(true);
            String content = (String) getIntent.invoke(intent, "");
            Log.v(tag, "Descriptive tag: " + content);
        } catch (NoSuchMethodException e) {
            Log.e(tag, "", e);
        } catch (InvocationTargetException e) {
            Log.e(tag, "", e);
        } catch (IllegalAccessException e) {
            Log.e(tag, "", e);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static void dumpJellyBeanMr1(String tag, PendingIntent intent) {
        Log.v(tag, "Who has created: " + intent.getCreatorPackage() + ", uid=[" + intent.getCreatorUid() + "]");
        dumpTag(tag, intent);
        dumpContentIntent(tag, intent);
    }

    private static void dumpDefault(String tag, PendingIntent intent) {
        Log.v(tag, "Who has created: " + intent.getTargetPackage());
        dumpTag(tag, intent);
        dumpContentIntent(tag, intent);
    }
}
