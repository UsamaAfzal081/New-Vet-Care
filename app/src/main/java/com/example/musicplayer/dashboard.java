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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setContentView(R.layout.dashboard);
        btnprofile = findViewById(R.id.btnprofile);
        btnrout = findViewById(R.id.btnrout);
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
    }
}