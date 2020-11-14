package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PersonalActivity extends AppCompatActivity {

    String alias;
    TextView my_dreams;
    TextView taken_dreams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Intent intent = getIntent();
        alias=intent.getStringExtra("alias");
        my_dreams

    }
}
