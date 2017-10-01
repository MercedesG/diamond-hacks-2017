package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KitDisplay extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display);

        Intent intent = getIntent();
        int numAdults = Integer.parseInt(intent.getStringExtra(BuildAccount.ADULT_NUM));
        int numKids = Integer.parseInt(intent.getStringExtra(BuildAccount.KID_NUM));
        int numPets = Integer.parseInt(intent.getStringExtra(BuildAccount.PET_NUM));

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        String s = myRef.getKey();
        TextView box = (TextView) findViewById(R.id.checkBox1);
        box.setText(s);
        //import information from database
        //TODO
        // Capture the layout's TextView and set the string as its text

        TextView textView;
       // for (int i = 0; i < text.length; i++) {
         //   textView = (TextView) findViewById(text[i]);
            //fix to reflect actual price and suggested amount
           // textView.setText(numAdults+numKids+numPets);
        //}
    }
}
