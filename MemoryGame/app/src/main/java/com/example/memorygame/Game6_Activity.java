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
import android.widget.ImageView;
import android.widget.TextView;

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
        score = (TextView) findViewById(R.id.score_edit);

        btn0.setTag("0");
        btn1.setTag("1");
        btn2.setTag("2");
        btn3.setTag("3");
        btn4.setTag("4");
        btn5.setTag("5");

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
                        AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(Game6_Activity.this);
                        alertDialogBuilder2
                                .setMessage("Game OVER!\nScore: " + points)
                                .setCancelable(false)
                                .setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        startActivity(new Intent(Game6_Activity.this,MainActivity.class));
                                        finish();
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder2.create();
                        alertDialog.show();
                    }
                }, 3000);
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
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Game6_Activity.this);
                    alertDialogBuilder
                            .setMessage("Game OVER!\nScore: " + points)
                            .setCancelable(false)
                            .setPositiveButton("New", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(getApplicationContext(), Game6_Activity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(new Intent(Game6_Activity.this,MainActivity.class));
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
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
        }
        player.start();
    }

    public void pause(){
        if(player != null){
            player.pause();
        }
    }
}