package com.example.ducdv.uiteducation.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.ducdv.uiteducation.R;

public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 3000;
    private static final int REQUEST_PERMISSION_CODE = 320654;
    private static final String TAG = SplashActivity.class.getName();

    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        createHandler();
    }

    private void createHandler() {
        checkPermission();

        mThread = new Thread(){
            @Override
            public void run() {
                super.run();
                int waited = 0;
                while (waited <= SPLASH_DISPLAY_LENGTH){
                    try {
                        sleep(100);
                    }
                    catch (InterruptedException ex){
                        Log.e(TAG, ex.toString());
                    }
                    waited += 100;
                }
                SplashActivity.this.finish();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        };
        mThread.start();
    }

    private void checkPermission(){
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
            || (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED)
            || (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED )) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.ACCESS_NETWORK_STATE}, REQUEST_PERMISSION_CODE);
        }
    }
}
