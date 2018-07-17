package com.example.mob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.smssdk.SMSSDK;

public class MainActivity extends AppCompatActivity {

    private TextView phone;
    private TextView yzm;
    private Button getyzm;
    private Button dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yzm = findViewById(R.id.text_yzm);
        getyzm = findViewById(R.id.getyzm);
        dl = findViewById(R.id.dl);phone = findViewById(R.id.text_phone);
        getyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMSSDK.getVerificationCode("86",phone.getText().toString());

            }
        });
    }
}
