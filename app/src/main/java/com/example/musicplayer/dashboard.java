package com.example.musicplayer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class dashboard extends Activity {
    private Button btnprofile;
    private Button btnrout;
    private Button btnhistory;
    private Button btnfeedbak;
    private Button btnsetting;
    private Button btnsupport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        btnprofile = findViewById(R.id.btnprofile);
        btnrout = findViewById(R.id.btnrout);
        btnhistory = findViewById(R.id.btnhistory);
        btnfeedbak = findViewById(R.id.btnfeedbak);
        btnsetting = findViewById(R.id.btnsetting);
        btnsupport = findViewById(R.id.btnsupport);

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(dashboard.this, MainActivity2.class);
                startActivity(u);
            }
        });
        btnrout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(dashboard.this, MainActivity3.class);
                startActivity(v);
            }
        });
        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(dashboard.this, MainActivity4.class);
                startActivity(w);
            }
        });
        btnfeedbak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(dashboard.this, MainActivity5.class);
                startActivity(x);
            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(dashboard.this, MainActivity6.class);
                startActivity(y);
            }
        });
        btnsupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(dashboard.this, MainActivity7.class);
                startActivity(z);
            }
        });
    }
}