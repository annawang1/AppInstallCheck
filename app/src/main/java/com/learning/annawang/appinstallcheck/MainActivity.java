package com.learning.annawang.appinstallcheck;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        isPackageInstalled("com.google.apps.contacts", getPackageManager());
        isPackageInstalled("com.android.contacts", getPackageManager());
//        isPackageInstalled("com.android.providers.contacts", getPackageManager());
    }

    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packagename, 0);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packagename, 0);
            boolean enable = packageManager.getApplicationInfo(packagename, 0).enabled;
//            packageManager.queryIntentActivities()
//
            Log.i(TAG, "------------------installed, packageInfo = " + packageInfo
            + "\r\n"
            + "applicationInfo = " + applicationInfo
            + "\r\n"
            + "enable = " + enable);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "----------------not installed");
            return false;
        }
    }
}
