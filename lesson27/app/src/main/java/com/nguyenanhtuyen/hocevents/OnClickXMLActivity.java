package com.nguyenanhtuyen.hocevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OnClickXMLActivity extends AppCompatActivity {
    ImageView imgLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click_xmlactivity);
        addControls();
    }

    private void addControls() {
        imgLight = findViewById(R.id.imgLight);
    }

    public void processOnOrOff(View view) {
        //Button là cái view mà mình tương tác trên giao diện
        //nên cài biến view trong processOnOrOff(View view) là Button
        Button btnSwitch = (Button) view;
        //view ngoài chức năng hiển thị dữ liệu còn cho phép tương tác
        //nó còn giúp ta gán các đối tượng (model) hay các biến bên trong nó thông qua thuộc tính tag
        Object tag = btnSwitch.getTag();
        if(tag == null || tag.equals("Turn_Off")) //mặc định = null tức là đèn đang tắt
        {
            //bật đèn
            //thay đổi ảnh đèn bật có trong mipmap
            imgLight.setImageResource(R.mipmap.ic_turn_on);
            //đánh dấu Button này vừa ra lệnh bật đền
            btnSwitch.setTag("Turn_On");
            btnSwitch.setText("Turn Off");
        }
        else //đèn đang bật
        {
            imgLight.setImageResource(R.mipmap.ic_turn_off);
            //ra lệnh tắt đèn
            btnSwitch.setTag("Turn_Off");
            btnSwitch.setText("Turn On");
        }
    }
}