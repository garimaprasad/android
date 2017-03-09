package com.example.garima.myapplication;

import android.content.Intent;
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

public class AddTwoNumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_two_num);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        num1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1.setText("");
                return false;
            }
        });
        num2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num2.setText("");
                return false;
            }
        });


        Button fab = (Button) findViewById(R.id.buttonAdd);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView out = (TextView) findViewById(R.id.output);
                try {
                long sum = AddTwoNum.getSum(Integer.parseInt(num1.getText().toString()) , Integer.parseInt(num2.getText().toString()));

                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    out.setText("The sum is "+sum);
                }
                catch (Exception e) {
                    // TODO: handle exception
                        out.setText("Invalid Input");
                     }


            }
        });
    }

}
