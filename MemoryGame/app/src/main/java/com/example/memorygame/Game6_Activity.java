package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;

public class Game6_Activity extends AppCompatActivity {

    ImageView btn0,btn1,btn2,btn3,btn4,btn5;
    Button play_btn, pause_btn,tryAgain_btn,newGame_btn,endGame_btn;
    MediaPlayer player;
    TextView score;

    //Array for 6 images
    Integer[] cardsArray = {101,102,103,201,202,203};
    //Actual images
    int image101,image102,image103,image201,image202,image203;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int points = 0;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    String stringScore1 = "";
    String stringScore2 = "";
    String stringScore3 = "";
    String userName_string ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game6);

        play_btn = findViewById(R.id.play_btn);
        pause_btn = findViewById(R.id.pause_btn);
        btn0 = (ImageView) findViewById(R.id.btn0);
        btn1 = (ImageView) findViewById(R.id.btn1);
        btn2 = (ImageView) findViewById(R.id.btn2);
        btn3 = (ImageView) findViewById(R.id.btn3);
        btn4 = (ImageView) findViewById(R.id.btn4);
        btn5 = (ImageView) findViewById(R.id.btn5);
        tryAgain_btn = findViewById(R.id.tryAgain_btn);
        endGame_btn = findViewById(R.id.endGame_btn);
        newGame_btn = findViewById(R.id.newGame_btn);
        score = (TextView) findViewById(R.id.score_edit);

        btn0.setTag("0");
        btn1.setTag("1");
        btn2.setTag("2");
        btn3.setTag("3");
        btn4.setTag("4");
        btn5.setTag("5");

        stringScore1 = readFromFile("level6_sc1.txt");
        stringScore2 = readFromFile("level6_sc2.txt");
        stringScore3 = readFromFile("level6_sc3.txt");
        score1 = Integer.parseInt(stringScore1);
        score2 = Integer.parseInt(stringScore2);
        score3 = Integer.parseInt(stringScore3);


        //load the card images
        frontOfCardsResources();
        //shuffle the card array
        Collections.shuffle(Arrays.asList(cardsArray));

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn0, theCard);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn1, theCard);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn2, theCard);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn3, theCard);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn4, theCard);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn5, theCard);
            }
        });

        tryAgain_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCardBack();
            }
        });

        endGame_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!userName_string.equals("")){
                            updateScoreBoard();
                        }
                        stop();
                        startActivity(new Intent(Game6_Activity.this,MainActivity.class));
                        finish();
                    }
                }, 3000);
            }
        });

        newGame_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userName_string.equals("")){
                    updateScoreBoard();
                }
                stop();
                startActivity(new Intent(Game6_Activity.this,Game6_Activity.class));
                finish();
            }
        });

    }

    //check which image is selected and save it to temp variable
    private void doStuff(ImageView btn, int card){
        if(cardsArray[card] == 101){
            btn.setImageResource(image101);
        } else if(cardsArray[card] == 102){
            btn.setImageResource(image102);
        } else if(cardsArray[card] == 103){
            btn.setImageResource(image103);
        } else if(cardsArray[card] == 201){
            btn.setImageResource(image201);
        } else if(cardsArray[card] == 202){
            btn.setImageResource(image202);
        } else if(cardsArray[card] == 203){
            btn.setImageResource(image203);
        }

        if(cardNumber ==1){
            firstCard = cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            btn.setEnabled(false);
        } else if(cardNumber ==2){
            secondCard = cardsArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            btn0.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        //if images are equal, remove them and add points
        if(firstCard == secondCard) {
            if(clickedFirst == 0){
                btn0.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 1){
                btn1.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 2){
                btn2.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 3){
                btn3.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 4){
                btn4.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 5){
                btn5.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                btn0.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 1){
                btn1.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 2){
                btn2.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 3){
                btn3.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 4){
                btn4.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 5){
                btn5.setVisibility(View.INVISIBLE);
            }

            //add pts;
            points=points+2;
            score.setText("Score: " + points);

        }else{
            //need to deduct pts
            points--;
            if(points < 0){
                points = 0;
            }
            score.setText("Score: " + points);
            btn0.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            return;
        }

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void flipCardBack(){
        btn0.setImageResource(R.drawable.ic_back);
        btn1.setImageResource(R.drawable.ic_back);
        btn2.setImageResource(R.drawable.ic_back);
        btn3.setImageResource(R.drawable.ic_back);
        btn4.setImageResource(R.drawable.ic_back);
        btn5.setImageResource(R.drawable.ic_back);

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
    }

    private void checkEnd(){
        if(btn0.getVisibility() ==View.INVISIBLE &&
                btn1.getVisibility() ==View.INVISIBLE &&
                btn2.getVisibility() ==View.INVISIBLE &&
                btn3.getVisibility() ==View.INVISIBLE &&
                btn4.getVisibility() ==View.INVISIBLE &&
                btn5.getVisibility() ==View.INVISIBLE){
            showAnswer();
            tryAgain_btn.setEnabled(false);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getUserName();
                }
            }, 3000);
        }
    }

    private void frontOfCardsResources() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
    }

    private void showAnswer(){
        if(cardsArray[0]==101){
            btn0.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[0]==102){
            btn0.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[0]==103){
            btn0.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[0]==201){
            btn0.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[0]==202){
            btn0.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[0]==203){
            btn0.setImageResource(R.drawable.ic_image203);
        }

        if(cardsArray[1]==101){
            btn1.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[1]==102){
            btn1.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[1]==103){
            btn1.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[1]==201){
            btn1.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[1]==202){
            btn1.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[1]==203){
            btn1.setImageResource(R.drawable.ic_image203);
        }

        if(cardsArray[2]==101){
            btn2.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[2]==102){
            btn2.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[2]==103){
            btn2.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[2]==201){
            btn2.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[2]==202){
            btn2.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[2]==203){
            btn2.setImageResource(R.drawable.ic_image203);
        }

        if(cardsArray[3]==101){
            btn3.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[3]==102){
            btn3.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[3]==103){
            btn3.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[3]==201){
            btn3.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[3]==202){
            btn3.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[3]==203){
            btn3.setImageResource(R.drawable.ic_image203);
        }

        if(cardsArray[4]==101){
            btn4.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[4]==102){
            btn4.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[4]==103){
            btn4.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[4]==201){
            btn4.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[4]==202){
            btn4.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[4]==203){
            btn4.setImageResource(R.drawable.ic_image203);
        }

        if(cardsArray[5]==101){
            btn5.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[5]==102){
            btn5.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[5]==103){
            btn5.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[5]==201){
            btn5.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[5]==202){
            btn5.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[5]==203){
            btn5.setImageResource(R.drawable.ic_image203);
        }

        btn0.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
    }

    public void play(){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.music1);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(){
        if(player != null){
            player.pause();
        }
    }

    public void stop(){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
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

    public void updateScoreBoard(){
        if(points> score1){
            //write initials
            writeToFile("level6_init1.txt",userName_string);
            //write scores
            writeToFile("level6_sc1.txt",String.valueOf(points));
        }else if(points> score2){
            //write initials
            writeToFile("level6_init2.txt",userName_string);
            //write scores
            writeToFile("level6_sc2.txt",String.valueOf(points));
        }else if(points> score3){
            //write initials
            writeToFile("level6_init3.txt",userName_string);
            //write scores
            writeToFile("level6_sc3.txt",String.valueOf(points));
        }
    }

    public void getUserName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game6_Activity.this);
        alert.setTitle("GAME OVER!\nScore: " + points);
        alert.setMessage("Please enter 3 initials, if Cancel clicked, it's set to zzz");
        // Set an EditText view to get user input
        final EditText input = new EditText(Game6_Activity.this);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = String.valueOf(input.getText());
                // Do something with value!
                userName_string = value;
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
                userName_string = "zzz";
            }
        });
        alert.show();
    }


}