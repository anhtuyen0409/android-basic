package com.nguyenanhtuyen.hoctimertask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView txtTimer;
    TimerTask timerTask;
    Timer timer;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aaa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        txtTimer = findViewById(R.id.txtTimer);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Calendar calendar = Calendar.getInstance();
                        String value = sdf.format(calendar.getTime());
                        txtTimer.setText(value);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }
}