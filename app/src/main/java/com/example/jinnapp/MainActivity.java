package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText namae;
    EditText psw;
    Button submit_log;
    Button create_acc;
    String alias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namae=(EditText)findViewById(R.id.new_title);
        psw=(EditText)findViewById(R.id.new_description);
        submit_log =(Button)findViewById(R.id.submit_log);
        create_acc=(Button)findViewById(R.id.create_acc);

        submit_log.setOnClickListener(this);
        create_acc.setOnClickListener(this);

        alias=namae.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Write a message to the database
//        DatabaseReference myRef = database.getReference("message/wishes/@ella");
//        myRef.setValue("StPetersburg;@ella;I dream so much to go there");
//        DatabaseReference myRef1 = database.getReference("message/wishes/@jimmy_hendrix");
//        myRef1.setValue("Coffee;@jimmy_hendrix;I dreamed about coffee for so long! But I am at university right now and can't skip lesson to go and buy coffee, Can you buy it for me please?");
//        DatabaseReference myRef2 = database.getReference("message/wishes/@minecrafter");
//        myRef2.setValue("Minecraft;@minecrafter;I wanna many diamonds, do you have one?");
        DatabaseReference myRef3 = database.getReference("message/profiles/@minecrafter/my_dream");
        myRef3.setValue("Minecraft;@minecrafter;I wanna many diamonds, do you have one?");
        DatabaseReference myRef4 = database.getReference("message/profiles/@minecrafter/taken_dream");
        myRef4.setValue("StPetersburg;@ella;I dream so much to go there");


        // Read from the database

        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("DB", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("DB", "Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    public void onClick(View view)
    {
        Log.d("Button","clicked");
        switch (view.getId())
        {
            case R.id.submit_log:
                Log.d("aliass",alias);
                Intent intent1 = new Intent(MainActivity.this,WishTableActivity.class);
                intent1.putExtra("alias",alias);
                startActivity(intent1);
                break;
            case R.id.create_acc:
                Log.d("Button","creating");
                Intent intent2 = new Intent(MainActivity.this,NewAcc.class);
                startActivity(intent2);
                break;
            //handle multiple view click events
        }
    }

}
