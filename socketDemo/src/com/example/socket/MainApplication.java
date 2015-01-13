package com.example.socket;

import android.app.Application;
import android.content.pm.PackageManager;

/**
 * @author TechBirds
 * @date 15-1-13
 * @time 下午12:33
 * @vsersion 1.0
 */
public class MainApplication extends Application {

    private static MainApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static MainApplication getInstance() {
        return mInstance;
    }

    public static String getCurrentVersion() {
        String currentVersion = "UNKNOWN";
        try {
            String packageName = mInstance.getPackageName();
            PackageManager packageManager = mInstance.getPackageManager();
            if (packageManager != null) {
                currentVersion = packageManager.getPackageInfo(packageName, 0).versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return currentVersion;
    }

}
