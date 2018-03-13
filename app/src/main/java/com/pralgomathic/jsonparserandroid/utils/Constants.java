package com.pralgomathic.jsonparserandroid.utils;

import android.util.Log;

/**
 * Created by jumman on 3/13/18.
 */


public class Constants {
    public final static String BASE_URL = "https://raw.githubusercontent.com/pralgomathic/SimpleJSONParserAndroid/master/app/src/main/java/com/pralgomathic/jsonparserandroid/sample_json.txt";
    private static boolean isDebugLogOn = true;

    public static void debugLog(String tag, String message) {
        if (isDebugLogOn) {
            Log.d(tag + " -----> ", message);
        }
    }

    public static void errorLog(String tag, String message) {
        if (isDebugLogOn) {
            Log.d(tag + " -----> ", message);
        }
    }
}