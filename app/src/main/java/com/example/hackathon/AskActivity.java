package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AskActivity extends AppCompatActivity {

    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("hackathon/ask");
    }

    public String readInput(){
        EditText userInput = findViewById(R.id.userInput);
        return userInput.getText().toString();
    }

    public void submit(View view){
        myRef.push().setValue(readInput());
    }
}