package com.prontoresolved.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.testdemo.com.prontoresolved.R;

public class LaunchScreen extends BaseActivity {

    Handler handler;
    @Override
    public void _onCreateOfActivity(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(LaunchScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
