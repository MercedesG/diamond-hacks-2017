package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DisplayLists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lists);
        Intent intent = getIntent();

        String[] text = {"Emergency Kit List"};

        for (int i = 0; i < text.length; i++) {
            RadioButton r = (RadioButton) findViewById(R.id.radioButton);
            r.setVisibility(View.VISIBLE);
            r.setText(text[i]);
        }
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent;
        intent = new Intent(this, KitDisplay.class);
        startActivity(intent);
    }
}
