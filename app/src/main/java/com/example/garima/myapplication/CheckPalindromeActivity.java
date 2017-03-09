package com.example.garima.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckPalindromeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_palindrome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText input = (EditText) findViewById(R.id.input);
        input.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                input.setText("");
                return false;
            }
        });


        Button fab = (Button) findViewById(R.id.buttonCheck);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String palin = CheckPalindrome.checkPalindrome(input.getText().toString());
                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                catch (Exception e) {     // TODO: handle exception
                }
                TextView out = (TextView) findViewById(R.id.output);

                out.setText(palin);

            }
        });
    }
}
