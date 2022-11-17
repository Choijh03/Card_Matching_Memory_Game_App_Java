package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn4,btn6,btn8,btn10,btn12,btn14,btn16,btn18,btn20,scores_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game4_Activity.class));
                finish();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game6_Activity.class));
                finish();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game8_Activity.class));
                finish();
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game10_Activity.class));
                finish();
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game12_Activity.class));
                finish();
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game14_Activity.class));
                finish();
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game16_Activity.class));
                finish();
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game18_Activity.class));
                finish();
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Game20_Activity.class));
                finish();
            }
        });

        scores_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Scores_Activity.class));
                finish();
            }
        });
    }
}