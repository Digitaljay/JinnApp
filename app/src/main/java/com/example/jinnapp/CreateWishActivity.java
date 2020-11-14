
package com.example.jinnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateWishActivity extends AppCompatActivity implements View.OnClickListener {

    EditText new_title;
    EditText new_description;
    String alias;
    Button submit_creating_wish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String alias = intent.getStringExtra("alias");
        setContentView(R.layout.activity_create_wish);
        new_title=(EditText)findViewById(R.id.new_title);
        new_description=(EditText)findViewById(R.id.new_description);
        submit_creating_wish=(Button)findViewById(R.id.submit_creating_wish);
        submit_creating_wish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.submit_creating_wish:
                Log.d("Wish","created");
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                // Write a message to the database
                DatabaseReference myRef = database.getReference("message/dreams/"+alias);

                myRef.setValue(new_title.getText().toString()+";"+alias+";"+new_description.getText().toString());
                Intent intent4 = new Intent(CreateWishActivity.this,WishTableActivity.class);
                startActivity(intent4);
                Toast.makeText(this, "Wish you dream come true!", Toast.LENGTH_SHORT).show();

                break;
        }
    }

}
