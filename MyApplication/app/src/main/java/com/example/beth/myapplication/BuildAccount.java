package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuildAccount extends AppCompatActivity {
    public static final String ADULT_NUM = "com.example.myfirstapp.ADULT_NUM";
    public static final String KID_NUM = "com.example.myfirstapp.KID_NUM";
    public static final String PET_NUM = "com.example.myfirstapp.KID_NUM";
    private String listName;
    // Write a message to the database
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference listRef = database.getReference("account");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        this.listName = intent.getStringExtra(MainActivity.MAIN_MESSAGE);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, KitDisplay.class);
        //Save number of adults
        EditText editText1 = (EditText) findViewById(R.id.numAdults);
        int numberOfAdults = Integer.parseInt(editText1.getText().toString());
        //Save number of kids
        EditText editText2 = (EditText) findViewById(R.id.numKids);
        int numberOfKids = Integer.parseInt(editText2.getText().toString());
        //Save number of pets
        EditText editText3 = (EditText) findViewById(R.id.numPets);
        int numberOfPets = Integer.parseInt(editText3.getText().toString());
        Account a = new Account(listName,numberOfAdults,numberOfKids,numberOfPets);
        listRef.push().setValue(a);
        startActivity(intent);
    }
}
