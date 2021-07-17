package com.example.hackathon.LoginScreens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.hackathon.R;


public class SignupActivity extends AppCompatActivity {
    Button register;
    EditText userName,passWord;
    FirebaseAuth authenticator = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userName = findViewById(R.id.Username);
        passWord = findViewById(R.id.Password);
        register = findViewById(R.id.register);
        String email = userName.getText().toString();
        String password = passWord.getText().toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticator.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupActivity.this,"signupcompleted",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(SignupActivity.this,"signupfailed",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }
}