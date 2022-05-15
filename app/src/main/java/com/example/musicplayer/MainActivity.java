package com.example.musicplayer;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSignUP;
    private Button btnAboutUs;
    private Button btnContactUs;
    private Button btnLogin;





        @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        btnContactUs=findViewById(R.id.btnContactUs);
        btnAboutUs=findViewById(R.id.btnAboutUs);
        btnSignUP=findViewById(R.id.btnSignUP);
        btnLogin=findViewById(R.id.btnLogin);
            EditText username = (EditText)findViewById(R.id.EtUsername);
            EditText password = (EditText)findViewById(R.id.Etpass);

        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent u = new Intent(MainActivity.this,dashboard.class);
                    startActivity(u);
            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AboutUs.class);
                startActivity(i);
            }
        });
        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this , ContactUs.class);
                        startActivity(in);
            }
        });

    }
}