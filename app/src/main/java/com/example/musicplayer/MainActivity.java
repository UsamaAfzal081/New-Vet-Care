package com.example.musicplayer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button btnSignUP;
    private Button btnAboutUs;
    private Button btnContactUs;
    private Button btnLogin;
    EditText EtEmail,Etpass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;



        @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);
        btnContactUs=findViewById(R.id.btnContactUs);
        btnAboutUs=findViewById(R.id.btnAboutUs);
        btnSignUP=findViewById(R.id.btnSignUP);
        btnLogin=findViewById(R.id.btnLogin);
            EtEmail=findViewById(R.id.EtEmail);
            Etpass=findViewById(R.id.Etpass);
            progressDialog=new ProgressDialog(this);
            mAuth=FirebaseAuth.getInstance();
            mUser=mAuth.getCurrentUser();

            EditText username = (EditText)findViewById(R.id.EtEmail);
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
                perforlogin();
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

    private void perforlogin() {
        String Email=EtEmail.getText().toString();
        String Password=Etpass.getText().toString();

        if(Email.matches(emailPattern))
        {
            EtEmail.setError("Enter Correct Email");
        }
        else if(Password.isEmpty()|| Password.length()<6)
        {
            Etpass.setError("Enter Proper Password");
        }
        else {
            progressDialog.setMessage("Login in progress");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    progressDialog.dismiss();
                    sendUserToNextActivity();
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT);
                }else
                {
                    progressDialog.dismiss();
                    Toast.makeText( MainActivity.this,""+task.getException(), Toast.LENGTH_SHORT );
                }
                }
            });
        }
    }
    private void sendUserToNextActivity() {
        Intent intent=new Intent(MainActivity.this,dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}