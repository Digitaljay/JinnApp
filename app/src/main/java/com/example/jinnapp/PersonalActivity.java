package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonalActivity extends AppCompatActivity {

    String alias;
    TextView my_dreams;
    TextView taken_dreams;
    TextView alias_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Intent intent = getIntent();
        alias=intent.getStringExtra("alias");
        my_dreams=(TextView)findViewById(R.id.my_dreams);
        taken_dreams=(TextView)findViewById(R.id.taken_dreams);
        alias_profile=(TextView)findViewById(R.id.alias_profile);
        alias_profile.setText(alias);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference ref = database.getReference("message/profiles/"+alias+"/my_dream");

// Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mine = dataSnapshot.getValue(String.class);
                my_dreams.setText(mine);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        DatabaseReference ref1 = database.getReference("message/profiles/"+alias+"/taken_dream");

// Attach a listener to read the data at our posts reference
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String taken = dataSnapshot.getValue(String.class);
                my_dreams.setText(taken);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });




    }
}
