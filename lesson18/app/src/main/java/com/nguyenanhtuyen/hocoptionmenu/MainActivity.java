package com.nguyenanhtuyen.hocoptionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //nạp file main_menu
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //viết sự kiện cho menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuHuongDan:
                Intent intentHuongDan = new Intent(MainActivity.this,HuongDanActivity.class);
                startActivity(intentHuongDan);
                break;
            case R.id.mnuGioiThieu:
                Intent intentGioiThieu = new Intent(MainActivity.this,GioiThieuActivity.class);
                startActivity(intentGioiThieu);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}