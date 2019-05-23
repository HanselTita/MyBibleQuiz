package com.softhans.mybiblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent(LoadingPage.this, MainActivity.class);
                startActivity(intent);
                finishscreen();
            }
        };
        Timer t = new Timer();
        t.schedule(task, 5000);
    }

    private void finishscreen() {
        this.finish();
    }
}
