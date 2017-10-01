package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.Iterator;

public class KitDisplay extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    // Write a message to the database
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference listRef = database.getReference("list");
    private DatabaseReference purchaseRef = database.getReference("Purchase");
    private DatabaseReference packedRef = database.getReference("Packed");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display);

        Intent intent = getIntent();
        Item val = new Item("water bottles", 1.0, 50, 0, "Monday");

        Button buttonTest = (Button) findViewById(R.id.button2);
        // Send button sends a message and clears the EditText
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creates a new FriendlyMessage object
                Item val = new Item("snacks", 1.0, 50, 0, "Monday");
                listRef.push().setValue(val);
            }
        });

        // Read from the database
        listRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Item value = dataSnapshot.getValue(Item.class);
                EditText box = (EditText) findViewById(R.id.editText3);
                box.setText(value.getName());

                String stuff = purchaseRef.child("Basic").child("Battery Radio").getKey();
                box.setText(stuff);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        String s = listRef.getKey();
        //EditText box = (EditText) findViewById(R.id.editText3);
        //box.setText(s);
        //listRef.push().setValue(val);

    }
}
