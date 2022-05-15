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

public class SignUp extends AppCompatActivity {
    private Button btnSignUP1;
    EditText SuEmail,SuUsername,SuPass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        btnSignUP1=findViewById(R.id.btnSignUp1);
        SuEmail=findViewById(R.id.SuEmail);
        SuUsername=findViewById(R.id.SuUsername);
        SuPass=findViewById(R.id.SuPass);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        btnSignUP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
                    Intent u = new Intent(SignUp.this,dashboard.class);
                    startActivity(u);
            }
        });
    }

    private void PerforAuth() {
        String Email=SuEmail.getText().toString();
        String Password=SuUsername.getText().toString();
        String Confirm_Password=SuPass.getText().toString();

        if(Email.matches(emailPattern))
        {
            SuEmail.setError("Enter Correct Email");
        }
        else if(Password.isEmpty()|| Password.length()<6)
        {
            SuUsername.setError("Enter Proper Password");
        }
        else if(!Password.equals(Confirm_Password))
        {
            SuPass.setError("Password did not matched");
        }
        else
        {
            progressDialog.setMessage("Registration in progress");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT);
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText( SignUp.this,""+task.getException(), Toast.LENGTH_SHORT );
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(SignUp.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}