package com.nguyenanhtuyen.hocevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openOnClickXMLActivity(View view) {
        //làm thế nào để mở 1 màn hình nào đó lên:
        //ta dùng Intent
        //đối số 1: màn hình hiện tại .this (MainActivity là màn hình hiện tại nên viết MainActivity.this)
        //đối số 2: là màn hình muốn mở lên .class
                    //ta muốn mở OnClickXMLActivity thì gõ OnClickXMLActivity.class
        Intent intent = new Intent(MainActivity.this,OnClickXMLActivity.class);
        //gọi lệnh sau để mở màn hình OnClickXMLActivity
        startActivity(intent);
    }


    public void openAnonymousListenerActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AnonymousListenerActivity.class);
        startActivity(intent);
    }
}