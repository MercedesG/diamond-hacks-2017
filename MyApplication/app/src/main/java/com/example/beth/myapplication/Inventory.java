package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Inventory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Item[][] purchaseList = new Item[3][];
        Item[] adultItems = new Item[8];
        Item[] kidItems = new Item[6];
        Item[] petItems = new Item[6];
        purchaseList[0] = adultItems;
        purchaseList[1] = kidItems;
        purchaseList[2] = petItems;
        adultItems[0] = new Item("Battery Radio", 13.89, 1, 0, null);
        adultItems[1] = new Item("First Aid Kit", 7.97, 1, 0, null);
        adultItems[2] = new Item("Flashlight", 4.47, 1, 0, null);
        adultItems[3] = new Item("Nonperishable Food", 24.75, 9, 0, null);
        adultItems[4] = new Item("Water (gallons)", 1, 1, 0, null);
        adultItems[5] = new Item("Cellphone", 0, 1, 0, null);
        adultItems[6] = new Item("Charger", 0, 1, 0, null);
        adultItems[7] = new Item("Clothing", 0, 1, 0, null);
        kidItems[0] = new Item("Diapers", 34.94, 1, 0, null);
        kidItems[1] = new Item("Infant Formula", 19.98, 1, 0, null);
        kidItems[2] = new Item("Rash Cream", 3.47, 1, 0, null);
        kidItems[3] = new Item("Baby Bottle", 0, 1, 0, null);
        kidItems[4] = new Item("Books", 0, 1, 0, null);
        kidItems[5] = new Item("Games", 0, 1, 0, null);
        petItems[0] = new Item("Pet Carrier", 24.77, 1, 0, null);
        petItems[1] = new Item("Pet Food", 9.98, 1, 0, null);
        petItems[2] = new Item("Waste Bags", 4.87, 1, 0, null);
        petItems[3] = new Item("Collar", 0, 1, 0, null);
        petItems[4] = new Item("Picture of Pet", 0, 1, 0, null);
        petItems[5] = new Item("Tags", 0, 1, 0, null);

        int[] idArray = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4,
                R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8,
                R.id.textView9, R.id.textView10, R.id.textView11, R.id.textView12,
                R.id.textView13, R.id.textView14, R.id.textView15, R.id.textView16,
                R.id.textView17, R.id.textView18, R.id.textView19, R.id.textView20};
        int count = 0;
        for (int i = 0; i < purchaseList.length; i++) {
            for (int j = 0; j < purchaseList[i].length; j++) {
                CheckBox box = (CheckBox) findViewById(idArray[count]);
                box.setVisibility(View.VISIBLE);
                Item temp = purchaseList[i][j];
                String display = temp.getName();
                box.setText(display);
                count++;
            }
        }
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button:
                intent = new Intent(this, KitDisplay.class);
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
