package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    //Declarations
    Button btn4,btn6,btn8,btn10,btn12,btn14,btn16,btn18,btn20,scores_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting variables with correct objects
        btn4 = findViewById(R.id.size_4_btn);
        btn6 = findViewById(R.id.size_6_btn);
        btn8 = findViewById(R.id.size_8_btn);
        btn10 = findViewById(R.id.size_10_btn);
        btn12 = findViewById(R.id.size_12_btn);
        btn14 = findViewById(R.id.size_14_btn);
        btn16 = findViewById(R.id.size_16_btn);
        btn18 = findViewById(R.id.size_18_btn);
        btn20 = findViewById(R.id.size_20_btn);
        scores_btn = findViewById(R.id.scores_btn);

        //when btn4 clicked, do
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game4_Activity.class));
                finish();
            }
        });

        //when btn6 clicked, do
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game6_Activity.class));
                finish();
            }
        });

        //when btn8 clicked, do
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game8_Activity.class));
                finish();
            }
        });

        //when btn10 clicked, do
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game10_Activity.class));
                finish();
            }
        });

        //when btn12 clicked, do
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game12_Activity.class));
                finish();
            }
        });

        //when btn14 clicked, do
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game14_Activity.class));
                finish();
            }
        });

        //when btn16 clicked, do
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game16_Activity.class));
                finish();
            }
        });

        //when btn18 clicked, do
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game18_Activity.class));
                finish();
            }
        });

        //when btn20 clicked, do
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game20_Activity.class));
                finish();
            }
        });

        //when scores_btn clicked, do
        scores_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Scores_Activity.class));
                finish();
            }
        });

    }

}