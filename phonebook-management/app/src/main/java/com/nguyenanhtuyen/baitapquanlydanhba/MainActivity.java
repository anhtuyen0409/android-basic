package com.nguyenanhtuyen.baitapquanlydanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nguyenanhtuyen.adapter.ContactAdapter;
import com.nguyenanhtuyen.model.Contact;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    //listview và contactadapter
    ListView lvContact;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        fakeData();
    }

    private void fakeData() {
        Random rand = new Random();
        //giả lập dữ liệu là 500 người trong danh bạ
        for(int i=0; i<500; i++){
            Contact contact = new Contact();
            contact.setName("Tên "+i+"  -  ");
            String phone = "098";
            int x = rand.nextInt(3); //random từ 0 đến 2 (0,1,2)
            if(x==1){
                phone = "090";
            }
            else if(x==2){
                phone = "094";
            }
            for(int p=0; p<7; p++){
                phone+=rand.nextInt(10); //3 số đầu + 7 số cuối được random từ 0 đến 9
            }
            contact.setPhone(phone);
            contactAdapter.add(contact);
        }
    }

    private void addControls() {
        lvContact = findViewById(R.id.lvContact);
        //contactAdapter có 2 đối số
        //đối số 1 là màn hình hiện tại -> MainActivity
        //đối số 2 chinh là layout ta đã định nghĩa -> item
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.item);
        //set listview cho adapter
        lvContact.setAdapter(contactAdapter);
    }
}