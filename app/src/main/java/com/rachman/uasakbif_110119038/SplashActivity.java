package com.rachman.uasakbif_110119038;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * Identitas Diri
 * NIM  : 10119038
 * Kelas: IF-1
 * Nama : Rachman Aldiansyah
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ViewpagerActivity.class));
                finish();
            }
        }, 3000L); // 3000L = 3 detik
    }
}