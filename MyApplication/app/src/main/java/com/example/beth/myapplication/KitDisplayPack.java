package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class KitDisplayPack extends AppCompatActivity {
    public static final String PACK_TAB = "com.example.myfirstapp.PACK_TAB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display_pack);

        Item[][] packList = new Item[3][];
        Item[] adultItems = new Item[3];
        Item[] kidItems = new Item[3];
        Item[] petItems = new Item[3];
        packList[0] = adultItems;
        packList[1] = kidItems;
        packList[2] = petItems;
        adultItems[0] = new Item("Cellphone", 0, 1, 0, null);
        adultItems[1] = new Item("Charger", 0, 1, 0, null);
        adultItems[2] = new Item("Clothing", 0, 1, 0, null);
        kidItems[0] = new Item("Baby Bottle", 0, 1, 0, null);
        kidItems[1] = new Item("Books", 0, 1, 0, null);
        kidItems[2] = new Item("Games", 0, 1, 0, null);
        petItems[0] = new Item("Collar", 0, 1, 0, null);
        petItems[1] = new Item("Picture of Pet", 0, 1, 0, null);
        petItems[2] = new Item("Tags", 0, 1, 0, null);

        int[] idArray = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4,
                R.id.checkBox5, R.id.checkBox6, R.id.checkBox7, R.id.checkBox8,
                R.id.checkBox9};
        int count = 0;
        for (int i = 0; i < packList.length; i++) {
            for (int j = 0; j < packList[i].length; j++) {
                CheckBox box = (CheckBox) findViewById(idArray[count]);
                box.setVisibility(View.VISIBLE);
                Item temp = packList[i][j];
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
