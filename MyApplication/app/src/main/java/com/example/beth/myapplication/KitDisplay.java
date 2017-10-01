package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KitDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display);

        Intent intent = getIntent();
        int numAdults = Integer.parseInt(intent.getStringExtra(BuildAccount.ADULT_NUM));
        int numKids = Integer.parseInt(intent.getStringExtra(BuildAccount.KID_NUM));
        int numPets = Integer.parseInt(intent.getStringExtra(BuildAccount.PET_NUM));

        //import information from database
        //TODO
        // Capture the layout's TextView and set the string as its text
        int text[] = {
                R.id.itemNum1,
                R.id.itemNum2,
                R.id.itemNum3,
                R.id.itemNum4};

        TextView textView;
        for (int i = 0; i < text.length; i++) {
            textView = (TextView) findViewById(text[i]);
            //fix to reflect actual price and suggested amount
            textView.setText(numAdults+numKids+numPets);
        }
    }
}
