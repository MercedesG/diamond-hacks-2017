package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KitDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit_display);

        Intent intent = getIntent();
        //String message = intent.getStringExtra(BuildAccount.BUILD_MESSAGE);
    }
}
