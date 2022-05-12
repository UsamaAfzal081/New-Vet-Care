package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private Button btnSignUP1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        btnSignUP1=findViewById(R.id.btnSignUp1);
        EditText username = (EditText)findViewById(R.id.Suname);
        EditText password = (EditText)findViewById(R.id.SuPass);

        btnSignUP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")|| password.getText().toString().equals("")) {

                    Toast.makeText(SignUp.this, "please fill al fields", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(SignUp.this, "Welcome to dashboard", Toast.LENGTH_LONG).show();
                    Intent u = new Intent(SignUp.this,dashboard.class);
                    startActivity(u);
                }

            }
        });

    }
}