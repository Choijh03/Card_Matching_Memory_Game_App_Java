package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

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


        readScores();


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scores_Activity.this,MainActivity.class));
                finish();
            }
        });

    }

    public String readFromFile(String fileName){
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, fileName);
        byte[] content = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            return new String(content);
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }

    public void readScores(){
        tv_level4_initial1.setText(readFromFile("level4_init1.txt"));
        tv_level4_initial2.setText(readFromFile("level4_init2.txt"));
        tv_level4_initial3.setText(readFromFile("level4_init3.txt"));
        tv_level4_score1.setText(readFromFile("level4_sc1.txt"));
        tv_level4_score2.setText(readFromFile("level4_sc2.txt"));
        tv_level4_score3.setText(readFromFile("level4_sc3.txt"));

        tv_level6_initial1.setText(readFromFile("level6_init1.txt"));
        tv_level6_initial2.setText(readFromFile("level6_init2.txt"));
        tv_level6_initial3.setText(readFromFile("level6_init3.txt"));
        tv_level6_score1.setText(readFromFile("level6_sc1.txt"));
        tv_level6_score2.setText(readFromFile("level6_sc2.txt"));
        tv_level6_score3.setText(readFromFile("level6_sc3.txt"));

        tv_level8_initial1.setText(readFromFile("level8_init1.txt"));
        tv_level8_initial2.setText(readFromFile("level8_init2.txt"));
        tv_level8_initial3.setText(readFromFile("level8_init3.txt"));
        tv_level8_score1.setText(readFromFile("level8_sc1.txt"));
        tv_level8_score2.setText(readFromFile("level8_sc2.txt"));
        tv_level8_score3.setText(readFromFile("level8_sc3.txt"));

        tv_level10_initial1.setText(readFromFile("level10_init1.txt"));
        tv_level10_initial2.setText(readFromFile("level10_init2.txt"));
        tv_level10_initial3.setText(readFromFile("level10_init3.txt"));
        tv_level10_score1.setText(readFromFile("level10_sc1.txt"));
        tv_level10_score2.setText(readFromFile("level10_sc2.txt"));
        tv_level10_score3.setText(readFromFile("level10_sc3.txt"));

        tv_level12_initial1.setText(readFromFile("level12_init1.txt"));
        tv_level12_initial2.setText(readFromFile("level12_init2.txt"));
        tv_level12_initial3.setText(readFromFile("level12_init3.txt"));
        tv_level12_score1.setText(readFromFile("level12_sc1.txt"));
        tv_level12_score2.setText(readFromFile("level12_sc2.txt"));
        tv_level12_score3.setText(readFromFile("level12_sc3.txt"));

        tv_level14_initial1.setText(readFromFile("level14_init1.txt"));
        tv_level14_initial2.setText(readFromFile("level14_init2.txt"));
        tv_level14_initial3.setText(readFromFile("level14_init3.txt"));
        tv_level14_score1.setText(readFromFile("level14_sc1.txt"));
        tv_level14_score2.setText(readFromFile("level14_sc2.txt"));
        tv_level14_score3.setText(readFromFile("level14_sc3.txt"));

        tv_level16_initial1.setText(readFromFile("level16_init1.txt"));
        tv_level16_initial2.setText(readFromFile("level16_init2.txt"));
        tv_level16_initial3.setText(readFromFile("level16_init3.txt"));
        tv_level16_score1.setText(readFromFile("level16_sc1.txt"));
        tv_level16_score2.setText(readFromFile("level16_sc2.txt"));
        tv_level16_score3.setText(readFromFile("level16_sc3.txt"));

        tv_level18_initial1.setText(readFromFile("level18_init1.txt"));
        tv_level18_initial2.setText(readFromFile("level18_init2.txt"));
        tv_level18_initial3.setText(readFromFile("level18_init3.txt"));
        tv_level18_score1.setText(readFromFile("level18_sc1.txt"));
        tv_level18_score2.setText(readFromFile("level18_sc2.txt"));
        tv_level18_score3.setText(readFromFile("level18_sc3.txt"));

        tv_level20_initial1.setText(readFromFile("level20_init1.txt"));
        tv_level20_initial2.setText(readFromFile("level20_init2.txt"));
        tv_level20_initial3.setText(readFromFile("level20_init3.txt"));
        tv_level20_score1.setText(readFromFile("level20_sc1.txt"));
        tv_level20_score2.setText(readFromFile("level20_sc2.txt"));
        tv_level20_score3.setText(readFromFile("level20_sc3.txt"));
    }




}