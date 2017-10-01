package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private int numAdults = 2;
    private int numKids = 1;
    private int numPets = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display);

        Intent intent = getIntent();
//        if (intent != null) {
//            numAdults = intent.getIntExtra(BuildAccount.ADULT_NUM, 0);
//            numKids = intent.getIntExtra(BuildAccount.KID_NUM, 0);
//            numPets = intent.getIntExtra(BuildAccount.PET_NUM, 0);
//        }

        Item[][] purchaseList = new Item[3][];
        Item[] adultItems = new Item[5];
        Item[] kidItems = new Item[3];
        Item[] petItems = new Item[3];
        purchaseList[0] = adultItems;
        purchaseList[1] = kidItems;
        purchaseList[2] = petItems;
        adultItems[0] = new Item("Battery Radio", 13.89, 1, 0, null);
        adultItems[1] = new Item("First Aid Kit", 7.97, 1, 0, null);
        adultItems[2] = new Item("Flashlight", 4.47, 1*numAdults, 0, null);
        adultItems[3] = new Item("Nonperishable Meals", 24.75, 9*(numAdults+numKids), 0, null);
        adultItems[4] = new Item("Water (gallons)", 1, 1*(numAdults+numKids+numPets), 0, null);
        kidItems[0] = new Item("Diapers", 34.94, 1*numKids, 0, null);
        kidItems[1] = new Item("Infant Formula", 19.98, 1*numKids, 0, null);
        kidItems[2] = new Item("Rash Cream", 3.47, 1*numKids, 0, null);
        petItems[0] = new Item("Pet Carrier", 24.77, 1*numPets, 0, null);
        petItems[1] = new Item("Pet Food", 9.98, 1*numPets, 0, null);
        petItems[2] = new Item("Waste Bags", 4.87, 1*numPets, 0, null);

        int[] idArray = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4,
                        R.id.checkBox5, R.id.checkBox6, R.id.checkBox7, R.id.checkBox8,
                        R.id.checkBox9, R.id.checkBox10, R.id.checkBox11};
        int count = 0;
        for (int i = 0; i < purchaseList.length; i++) {
            for (int j = 0; j < purchaseList[i].length; j++) {
                if (purchaseList[i][j].getQuantity() > 0) {
                    CheckBox box = (CheckBox) findViewById(idArray[count]);
                    box.setVisibility(View.VISIBLE);
                    Item temp = purchaseList[i][j];
                    double p = temp.getPrice();
                    String display = String.format("$%.2f     %s x %d",
                            temp.getPrice(), temp.getName(), temp.getQuantity());
                    if (p < 10) {
                        display = " " + display;
                    }
                    box.setText(display);
                    count++;
                }
            }
        }

        //Everything after this doesn't matter

        //Button buttonTest = (Button) findViewById(R.id.button2);
        // Send button sends a message and clears the EditText
        //buttonTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 Creates a new FriendlyMessage object
//                Item val = new Item("snacks", 1.0, 50, 0, "Monday");
//                listRef.push().setValue(val);
//            }
//        });

        // Read from the database
        listRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //Log.e("onChildAdded",s);
//                Item value = dataSnapshot.getValue(Item.class);
//                EditText box = (EditText) findViewById(R.id.editText3);
//                box.setText(value.getName());

//                String stuff = purchaseRef.child("Basic").child("Battery Radio").getKey();
//                box.setText(stuff);
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
//        String s = listRef.getKey();
        //EditText box = (EditText) findViewById(R.id.editText3);
        //box.setText(s);

//        listRef.push().setValue(adultItems[0]);

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.pack:
                intent = new Intent(this, KitDisplayPack.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, Inventory.class);
                startActivity(intent);
                break;
            default:
                //fail
        }
    }

}
