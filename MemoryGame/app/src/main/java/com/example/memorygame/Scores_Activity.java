package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Scores_Activity extends AppCompatActivity {

    Button btn_back;
    TextView tv_level4_initial1, tv_level4_initial2, tv_level4_initial3, tv_level6_initial1, tv_level6_initial2, tv_level6_initial3,
            tv_level8_initial1, tv_level8_initial2, tv_level8_initial3, tv_level10_initial1, tv_level10_initial2, tv_level10_initial3,
            tv_level12_initial1, tv_level12_initial2, tv_level12_initial3, tv_level14_initial1, tv_level14_initial2, tv_level14_initial3,
            tv_level16_initial1, tv_level16_initial2, tv_level16_initial3, tv_level18_initial1, tv_level18_initial2, tv_level18_initial3,
            tv_level20_initial1, tv_level20_initial2, tv_level20_initial3, tv_level4_score1, tv_level4_score2 ,tv_level4_score3,
            tv_level6_score1, tv_level6_score2, tv_level6_score3, tv_level8_score1, tv_level8_score2, tv_level8_score3,
            tv_level10_score1, tv_level10_score2, tv_level10_score3, tv_level12_score1, tv_level12_score2, tv_level12_score3,
            tv_level14_score1, tv_level14_score2, tv_level14_score3, tv_level16_score1, tv_level16_score2, tv_level16_score3,
            tv_level18_score1, tv_level18_score2, tv_level18_score3, tv_level20_score1, tv_level20_score2, tv_level20_score3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        btn_back = findViewById(R.id.btn_back);
        tv_level4_initial1 = (TextView) findViewById(R.id.tv_level4_initial1);
        tv_level4_initial2 = (TextView) findViewById(R.id.tv_level4_initial2);
        tv_level4_initial3 = (TextView) findViewById(R.id.tv_level4_initial3);
        tv_level4_score1 = (TextView) findViewById(R.id.tv_level4_score1);
        tv_level4_score2 = (TextView) findViewById(R.id.tv_level4_score2);
        tv_level4_score3 = (TextView) findViewById(R.id.tv_level4_score3);

        tv_level6_initial1 = (TextView) findViewById(R.id.tv_level6_initial1);
        tv_level6_initial2 = (TextView) findViewById(R.id.tv_level6_initial2);
        tv_level6_initial3 = (TextView) findViewById(R.id.tv_level6_initial3);
        tv_level6_score1 = (TextView) findViewById(R.id.tv_level6_score1);
        tv_level6_score2 = (TextView) findViewById(R.id.tv_level6_score2);
        tv_level6_score3 = (TextView) findViewById(R.id.tv_level6_score3);

        tv_level8_initial1 = (TextView) findViewById(R.id.tv_level8_initial1);
        tv_level8_initial2 = (TextView) findViewById(R.id.tv_level8_initial2);
        tv_level8_initial3 = (TextView) findViewById(R.id.tv_level8_initial3);
        tv_level8_score1 = (TextView) findViewById(R.id.tv_level8_score1);
        tv_level8_score2 = (TextView) findViewById(R.id.tv_level8_score2);
        tv_level8_score3 = (TextView) findViewById(R.id.tv_level8_score3);

        tv_level10_initial1 = (TextView) findViewById(R.id.tv_level10_initial1);
        tv_level10_initial2 = (TextView) findViewById(R.id.tv_level10_initial2);
        tv_level10_initial3 = (TextView) findViewById(R.id.tv_level10_initial3);
        tv_level10_score1 = (TextView) findViewById(R.id.tv_level10_score1);
        tv_level10_score2 = (TextView) findViewById(R.id.tv_level10_score2);
        tv_level10_score3 = (TextView) findViewById(R.id.tv_level10_score3);

        tv_level12_initial1 = (TextView) findViewById(R.id.tv_level12_initial1);
        tv_level12_initial2 = (TextView) findViewById(R.id.tv_level12_initial2);
        tv_level12_initial3 = (TextView) findViewById(R.id.tv_level12_initial3);
        tv_level12_score1 = (TextView) findViewById(R.id.tv_level12_score1);
        tv_level12_score2 = (TextView) findViewById(R.id.tv_level12_score2);
        tv_level12_score3 = (TextView) findViewById(R.id.tv_level12_score3);

        tv_level14_initial1 = (TextView) findViewById(R.id.tv_level14_initial1);
        tv_level14_initial2 = (TextView) findViewById(R.id.tv_level14_initial2);
        tv_level14_initial3 = (TextView) findViewById(R.id.tv_level14_initial3);
        tv_level14_score1 = (TextView) findViewById(R.id.tv_level14_score1);
        tv_level14_score2 = (TextView) findViewById(R.id.tv_level14_score2);
        tv_level14_score3 = (TextView) findViewById(R.id.tv_level14_score3);

        tv_level16_initial1 = (TextView) findViewById(R.id.tv_level16_initial1);
        tv_level16_initial2 = (TextView) findViewById(R.id.tv_level16_initial2);
        tv_level16_initial3 = (TextView) findViewById(R.id.tv_level16_initial3);
        tv_level16_score1 = (TextView) findViewById(R.id.tv_level16_score1);
        tv_level16_score2 = (TextView) findViewById(R.id.tv_level16_score2);
        tv_level16_score3 = (TextView) findViewById(R.id.tv_level16_score3);

        tv_level18_initial1 = (TextView) findViewById(R.id.tv_level18_initial1);
        tv_level18_initial2 = (TextView) findViewById(R.id.tv_level18_initial2);
        tv_level18_initial3 = (TextView) findViewById(R.id.tv_level18_initial3);
        tv_level18_score1 = (TextView) findViewById(R.id.tv_level18_score1);
        tv_level18_score2 = (TextView) findViewById(R.id.tv_level18_score2);
        tv_level18_score3 = (TextView) findViewById(R.id.tv_level18_score3);

        tv_level20_initial1 = (TextView) findViewById(R.id.tv_level20_initial1);
        tv_level20_initial2 = (TextView) findViewById(R.id.tv_level20_initial2);
        tv_level20_initial3 = (TextView) findViewById(R.id.tv_level20_initial3);
        tv_level20_score1 = (TextView) findViewById(R.id.tv_level20_score1);
        tv_level20_score2 = (TextView) findViewById(R.id.tv_level20_score2);
        tv_level20_score3 = (TextView) findViewById(R.id.tv_level20_score3);
    }
}