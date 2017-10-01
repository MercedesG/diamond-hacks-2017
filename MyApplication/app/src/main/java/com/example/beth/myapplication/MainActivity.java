package com.example.beth.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buildAccountButton:
                intent = new Intent(this, BuildAccount.class);
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();
                intent.putExtra(MAIN_MESSAGE, message);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, DisplayLists.class);
                startActivity(intent);
                break;
            default:
                //fail
        }
    }
}
