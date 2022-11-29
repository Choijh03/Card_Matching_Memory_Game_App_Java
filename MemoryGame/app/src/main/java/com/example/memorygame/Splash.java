package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //check if file exists, if not write data to file
        fileChecker_level4();
        fileChecker_level6();
        fileChecker_level8();
        fileChecker_level10();
        fileChecker_level12();
        fileChecker_level14();
        fileChecker_level16();
        fileChecker_level18();
        fileChecker_level20();

        //giving 3 seconds delay of splash screen with loading bard
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
                finish();
            }
        },3000);
    }


    // method: writeToFile
    // purpose: this method is to write the data into internal storage by accepting filename and data
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

    // method: writeScores
    // purpose: this method is to write score data into internal storage
    public void writeScores(){
        //creating files and writing data in internal drive
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
    }

    // method: fileChecker_level4
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level4(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level4_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_init1.txt", "avd");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level4_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_init2.txt", "dhj");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level4_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_init3.txt", "bdd");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level4_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_sc1.txt", "4");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level4_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_sc2.txt", "2");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level4_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level4_sc3.txt", "2");
        }
    }

    // method: fileChecker_level6
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level6(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level6_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_init1.txt", "gjs");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level6_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_init2.txt", "bhj");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level6_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_init3.txt", "xkd");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level6_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_sc1.txt", "6");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level6_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_sc2.txt", "3");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level6_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level6_sc3.txt", "0");
        }
    }

    // method: fileChecker_level8
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level8(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level8_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_init1.txt", "bgd");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level8_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_init2.txt", "lfc");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level8_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_init3.txt", "oed");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level8_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_sc1.txt", "8");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level8_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_sc2.txt", "4");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level8_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level8_sc3.txt", "0");
        }
    }

    // method: fileChecker_level10
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level10(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level10_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_init1.txt", "knd");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level10_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_init2.txt", "qwn");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level10_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_init3.txt", "oeq");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level10_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_sc1.txt", "10");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level10_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_sc2.txt", "5");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level10_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level10_sc3.txt", "0");
        }
    }

    // method: fileChecker_level12
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level12(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level12_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_init1.txt", "bke");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level12_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_init2.txt", "pas");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level12_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_init3.txt", "doc");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level12_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_sc1.txt", "12");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level12_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_sc2.txt", "6");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level12_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level12_sc3.txt", "0");
        }
    }

    // method: fileChecker_level14
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level14(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level14_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_init1.txt", "gla");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level14_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_init2.txt", "bid");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level14_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_init3.txt", "aaa");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level14_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_sc1.txt", "14");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level14_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_sc2.txt", "7");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level14_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level14_sc3.txt", "0");
        }
    }

    // method: fileChecker_level16
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level16(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level16_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_init1.txt", "www");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level16_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_init2.txt", "sdk");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level16_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_init3.txt", "pgv");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level16_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_sc1.txt", "16");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level16_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_sc2.txt", "8");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level16_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level16_sc3.txt", "0");
        }
    }


    // method: fileChecker_level18
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level18(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level18_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_init1.txt", "xck");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level18_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_init2.txt", "gfc");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level18_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_init3.txt", "qpa");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level18_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_sc1.txt", "18");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level18_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_sc2.txt", "9");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level18_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level18_sc3.txt", "0");
        }
    }

    // method: fileChecker_level20
    // purpose: this method is to check if file exists, if not write data into internal storage
    public void fileChecker_level20(){
        File file1 = new File(getApplicationContext().getFilesDir(),"level20_init1.txt");
        if(file1.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_init1.txt", "fff");
        }

        File file2 = new File(getApplicationContext().getFilesDir(),"level20_init2.txt");
        if(file2.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_init2.txt", "idk");
        }

        File file3 = new File(getApplicationContext().getFilesDir(),"level20_init3.txt");
        if(file3.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_init3.txt", "ocv");
        }

        File file4 = new File(getApplicationContext().getFilesDir(),"level20_sc1.txt");
        if(file4.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_sc1.txt", "20");
        }

        File file5 = new File(getApplicationContext().getFilesDir(),"level20_sc2.txt");
        if(file5.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_sc2.txt", "10");
        }

        File file6 = new File(getApplicationContext().getFilesDir(),"level20_sc3.txt");
        if(file6.exists()){
            //Do nothing
        }
        else{
            writeToFile("level20_sc3.txt", "0");
        }
    }

}