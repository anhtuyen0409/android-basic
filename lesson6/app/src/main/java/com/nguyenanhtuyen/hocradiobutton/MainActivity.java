package com.nguyenanhtuyen.hocradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai báo các control
    RadioButton radTuyetVoi, radKhaNgon, radTamOn, radDoTe;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        radTuyetVoi = findViewById(R.id.radTuyetVoi);
        radKhaNgon = findViewById(R.id.radKhaNgon);
        radTamOn = findViewById(R.id.radTamOn);
        radDoTe = findViewById(R.id.radDoTe);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    public void xuLyDanhGia(View view) {
        if(radTuyetVoi.isChecked()){
            txtKetQua.setText("Chúng tôi đã ghi nhận đánh giá của bạn là tuyệt vời! Cảm ơn bạn rất nhiều!");
        }
        else{
            if(radKhaNgon.isChecked()){
                txtKetQua.setText("Chúng tôi đã ghi nhận đánh giá của bạn lag khá ngon! Lần sau ghé nhé:)))");
            }
            else{
                if(radTamOn.isChecked()){
                    txtKetQua.setText("Tạm ổn ạ? Cảm ơn bạn chúng tôi sẽ cố gắng cải thiện!");
                }
                else{
                    txtKetQua.setText("Tệ lắm sao? hic, xin lỗi nha :((");
                }
            }
        }
    }
}