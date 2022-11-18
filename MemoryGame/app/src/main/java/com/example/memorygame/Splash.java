package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        writeToFile("level4_init1.txt", "avd");
        writeToFile("level4_init2.txt", "dhj");
        writeToFile("level4_init3.txt", "bdd");
        writeToFile("level4_sc1.txt", "4");
        writeToFile("level4_sc2.txt", "2");
        writeToFile("level4_sc3.txt", "0");

        writeToFile("level6_init1.txt", "gjs");
        writeToFile("level6_init2.txt", "bhj");
        writeToFile("level6_init3.txt", "xkd");
        writeToFile("level6_sc1.txt", "6");
        writeToFile("level6_sc2.txt", "3");
        writeToFile("level6_sc3.txt", "0");

        writeToFile("level8_init1.txt", "bgd");
        writeToFile("level8_init2.txt", "lfc");
        writeToFile("level8_init3.txt", "oed");
        writeToFile("level8_sc1.txt", "8");
        writeToFile("level8_sc2.txt", "4");
        writeToFile("level8_sc3.txt", "0");

        writeToFile("level10_init1.txt", "knd");
        writeToFile("level10_init2.txt", "qwn");
        writeToFile("level10_init3.txt", "oeq");
        writeToFile("level10_sc1.txt", "10");
        writeToFile("level10_sc2.txt", "5");
        writeToFile("level10_sc3.txt", "0");

        writeToFile("level12_init1.txt", "bke");
        writeToFile("level12_init2.txt", "pas");
        writeToFile("level12_init3.txt", "doc");
        writeToFile("level12_sc1.txt", "12");
        writeToFile("level12_sc2.txt", "6");
        writeToFile("level12_sc3.txt", "0");

        writeToFile("level14_init1.txt", "gla");
        writeToFile("level14_init2.txt", "bid");
        writeToFile("level14_init3.txt", "aaa");
        writeToFile("level14_sc1.txt", "14");
        writeToFile("level14_sc2.txt", "7");
        writeToFile("level14_sc3.txt", "0");

        writeToFile("level16_init1.txt", "www");
        writeToFile("level16_init2.txt", "sdk");
        writeToFile("level16_init3.txt", "pgv");
        writeToFile("level16_sc1.txt", "16");
        writeToFile("level16_sc2.txt", "8");
        writeToFile("level16_sc3.txt", "0");

        writeToFile("level18_init1.txt", "xck");
        writeToFile("level18_init2.txt", "gfc");
        writeToFile("level18_init3.txt", "qpa");
        writeToFile("level18_sc1.txt", "18");
        writeToFile("level18_sc2.txt", "9");
        writeToFile("level18_sc3.txt", "0");

        writeToFile("level20_init1.txt", "fff");
        writeToFile("level20_init2.txt", "idk");
        writeToFile("level20_init3.txt", "ocv");
        writeToFile("level20_sc1.txt", "20");
        writeToFile("level20_sc2.txt", "10");
        writeToFile("level20_sc3.txt", "0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },3000);
    }

    public void writeToFile(String fileName, String content){
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
            writer.write(content.getBytes());
            writer.close();
            //Toast.makeText(getApplicationContext(), "Wrote to file: " + fileName, Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}