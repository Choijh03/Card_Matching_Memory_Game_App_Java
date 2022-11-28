package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;

public class Game18_Activity extends AppCompatActivity {

    //Declarations(Change it depending on size of cards)
    ImageView btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17;
    Button play_btn, pause_btn,tryAgain_btn,newGame_btn,endGame_btn;
    MediaPlayer player;
    TextView score;

    //Array for 18 images(Change it depending on size of cards)
    Integer[] cardsArray = {101,102,103,104,105,106,107,108,109,201,202,203,204,205,206,207,208,209};
    //Actual images
    int image101,image102,image103,image104,image105,image106,image107,image108,image109,
            image201,image202,image203,image204,image205,image206,image207,image208,image209;

    //Necessary Variables(no Changed needed)
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
        setContentView(R.layout.activity_game18);

        //Connecting variables with correct objects(Change it depending on size of cards)
        //Change it depending on size of cards
        play_btn = findViewById(R.id.play_btn);
        pause_btn = findViewById(R.id.pause_btn);
        btn0 = (ImageView) findViewById(R.id.btn0);
        btn1 = (ImageView) findViewById(R.id.btn1);
        btn2 = (ImageView) findViewById(R.id.btn2);
        btn3 = (ImageView) findViewById(R.id.btn3);
        btn4 = (ImageView) findViewById(R.id.btn4);
        btn5 = (ImageView) findViewById(R.id.btn5);
        btn6 = (ImageView) findViewById(R.id.btn6);
        btn7 = (ImageView) findViewById(R.id.btn7);
        btn8 = (ImageView) findViewById(R.id.btn8);
        btn9 = (ImageView) findViewById(R.id.btn9);
        btn10 = (ImageView) findViewById(R.id.btn10);
        btn11 = (ImageView) findViewById(R.id.btn11);
        btn12 = (ImageView) findViewById(R.id.btn12);
        btn13 = (ImageView) findViewById(R.id.btn13);
        btn14 = (ImageView) findViewById(R.id.btn14);
        btn15 = (ImageView) findViewById(R.id.btn15);
        btn16 = (ImageView) findViewById(R.id.btn16);
        btn17 = (ImageView) findViewById(R.id.btn17);
        tryAgain_btn = findViewById(R.id.tryAgain_btn);
        endGame_btn = findViewById(R.id.endGame_btn);
        newGame_btn = findViewById(R.id.newGame_btn);
        score = (TextView) findViewById(R.id.score_edit);

        //setting number tags for each ImageView(Change it depending on size of cards)
        //Change it depending on size of cards
        btn0.setTag("0");
        btn1.setTag("1");
        btn2.setTag("2");
        btn3.setTag("3");
        btn4.setTag("4");
        btn5.setTag("5");
        btn6.setTag("6");
        btn7.setTag("7");
        btn8.setTag("8");
        btn9.setTag("9");
        btn10.setTag("10");
        btn11.setTag("11");
        btn12.setTag("12");
        btn13.setTag("13");
        btn14.setTag("14");
        btn15.setTag("15");
        btn16.setTag("16");
        btn17.setTag("17");

        //reading the score data from internal storage(Change it depending on level)
        //Change it depending on which level
        stringScore1 = readFromFile("level18_sc1.txt");
        stringScore2 = readFromFile("level18_sc2.txt");
        stringScore3 = readFromFile("level18_sc3.txt");
        score1 = Integer.parseInt(stringScore1);
        score2 = Integer.parseInt(stringScore2);
        score3 = Integer.parseInt(stringScore3);

        //show basic rules for the game
        //No need to change
        gameExplanation();

        //load the card images
        //No need to change
        frontOfCardsResources();
        //shuffle the card array
        //No need to change
        Collections.shuffle(Arrays.asList(cardsArray));

        //when play_btn clicked, do
        //No need to change
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

        //when pause_btn clicked, do
        //No need to change
        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();
            }
        });

        //when btn0 clicked, do
        //No need to change
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn0, theCard);
            }
        });

        //when btn1 clicked, do
        //No need to change
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn1, theCard);
            }
        });

        //when btn2 clicked, do
        //No need to change
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn2, theCard);
            }
        });

        //when btn3 clicked, do
        //No need to change
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn3, theCard);
            }
        });

        //when btn4 clicked, do
        //No need to change
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn4, theCard);
            }
        });

        //when btn5 clicked, do
        //No need to change
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn5, theCard);
            }
        });

        //when btn6 clicked, do
        //No need to change
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn6, theCard);
            }
        });

        //when btn7 clicked, do
        //No need to change
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn7, theCard);
            }
        });

        //when btn8 clicked, do
        //No need to change
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn8, theCard);
            }
        });

        //when btn9 clicked, do
        //No need to change
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn9, theCard);
            }
        });

        //when btn10 clicked, do
        //No need to change
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn10, theCard);
            }
        });

        //when btn11 clicked, do
        //No need to change
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn11, theCard);
            }
        });

        //when btn12 clicked, do
        //No need to change
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn12, theCard);
            }
        });

        //when btn13 clicked, do
        //No need to change
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn13, theCard);
            }
        });

        //when btn14 clicked, do
        //No need to change
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn14, theCard);
            }
        });

        //when btn15 clicked, do
        //No need to change
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn15, theCard);
            }
        });

        //when btn16 clicked, do
        //No need to change
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn16, theCard);
            }
        });

        //when btn17 clicked, do
        //No need to change
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(btn17, theCard);
            }
        });


        //when tryAgain_btn clicked, do
        //No need to change
        tryAgain_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCardBack();
            }
        });

        //when endGame_btn clicked, do
        //Change it depending on which Activity
        endGame_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnswer();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stop();
                        startActivity(new Intent(Game18_Activity.this,MainActivity.class));
                        finish();
                    }
                }, 3000);
            }
        });

        //when newGame_btn clicked, do
        //Change it depending on which Activity
        newGame_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                startActivity(new Intent(Game18_Activity.this,Game18_Activity.class));
                finish();
            }
        });

    }

    // method: doStuff
    // purpose: this method is to check which image is selected and save it to temp variable
    // Change it depending on size of cards
    private void doStuff(ImageView btn, int card){
        if(cardsArray[card] == 101){
            btn.setImageResource(image101);
        } else if(cardsArray[card] == 102){
            btn.setImageResource(image102);
        } else if(cardsArray[card] == 103){
            btn.setImageResource(image103);
        } else if(cardsArray[card] == 104){
            btn.setImageResource(image104);
        } else if(cardsArray[card] == 105){
            btn.setImageResource(image105);
        } else if(cardsArray[card] == 106){
            btn.setImageResource(image106);
        } else if(cardsArray[card] == 107){
            btn.setImageResource(image107);
        } else if(cardsArray[card] == 108){
            btn.setImageResource(image108);
        } else if(cardsArray[card] == 109){
            btn.setImageResource(image109);
        }  else if(cardsArray[card] == 201){
            btn.setImageResource(image201);
        } else if(cardsArray[card] == 202){
            btn.setImageResource(image202);
        } else if(cardsArray[card] == 203){
            btn.setImageResource(image203);
        } else if(cardsArray[card] == 204){
            btn.setImageResource(image204);
        } else if(cardsArray[card] == 205){
            btn.setImageResource(image205);
        } else if(cardsArray[card] == 206){
            btn.setImageResource(image206);
        } else if(cardsArray[card] == 207){
            btn.setImageResource(image207);
        } else if(cardsArray[card] == 208){
            btn.setImageResource(image208);
        } else if(cardsArray[card] == 209){
            btn.setImageResource(image209);
        }

        //setting firstCard
        if(cardNumber ==1){
            firstCard = cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            btn.setEnabled(false);
            //setting secondCard
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
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
            btn11.setEnabled(false);
            btn12.setEnabled(false);
            btn13.setEnabled(false);
            btn14.setEnabled(false);
            btn15.setEnabled(false);
            btn16.setEnabled(false);
            btn17.setEnabled(false);

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

    // method: calculate
    // purpose: this method is to check if two images are selected are equal or not
    // Change it depending on size of cards
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
            } else if(clickedFirst == 6){
                btn6.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 7){
                btn7.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 8){
                btn8.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 9){
                btn9.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 10){
                btn10.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 11){
                btn11.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 12){
                btn12.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 13){
                btn13.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 14){
                btn14.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 15){
                btn15.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 16){
                btn16.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 17){
                btn17.setVisibility(View.INVISIBLE);
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
            } else if(clickedSecond == 6){
                btn6.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 7){
                btn7.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 8){
                btn8.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 9){
                btn9.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 10){
                btn10.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 11){
                btn11.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 12){
                btn12.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 13){
                btn13.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 14){
                btn14.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 15){
                btn15.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 16){
                btn16.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 17){
                btn17.setVisibility(View.INVISIBLE);
            }

            //add 2pts;
            points=points+2;
            score.setText("Score: " + points);

        }else{
            //deduct 1pts
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
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
            btn11.setEnabled(false);
            btn12.setEnabled(false);
            btn13.setEnabled(false);
            btn14.setEnabled(false);
            btn15.setEnabled(false);
            btn16.setEnabled(false);
            btn17.setEnabled(false);
            return;
        }

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn12.setEnabled(true);
        btn13.setEnabled(true);
        btn14.setEnabled(true);
        btn15.setEnabled(true);
        btn16.setEnabled(true);
        btn17.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    // method: flipCardBack
    // purpose: this method is to set the card images back to original
    // Change it depending on size of cards
    private void flipCardBack(){
        btn0.setImageResource(R.drawable.ic_back);
        btn1.setImageResource(R.drawable.ic_back);
        btn2.setImageResource(R.drawable.ic_back);
        btn3.setImageResource(R.drawable.ic_back);
        btn4.setImageResource(R.drawable.ic_back);
        btn5.setImageResource(R.drawable.ic_back);
        btn6.setImageResource(R.drawable.ic_back);
        btn7.setImageResource(R.drawable.ic_back);
        btn8.setImageResource(R.drawable.ic_back);
        btn9.setImageResource(R.drawable.ic_back);
        btn10.setImageResource(R.drawable.ic_back);
        btn11.setImageResource(R.drawable.ic_back);
        btn12.setImageResource(R.drawable.ic_back);
        btn13.setImageResource(R.drawable.ic_back);
        btn14.setImageResource(R.drawable.ic_back);
        btn15.setImageResource(R.drawable.ic_back);
        btn16.setImageResource(R.drawable.ic_back);
        btn17.setImageResource(R.drawable.ic_back);

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn12.setEnabled(true);
        btn13.setEnabled(true);
        btn14.setEnabled(true);
        btn15.setEnabled(true);
        btn16.setEnabled(true);
        btn17.setEnabled(true);
    }

    // method: checkEnd
    // purpose: this method is to check the game process if it's ended
    // Change it depending on size of cards
    private void checkEnd(){
        if(btn0.getVisibility() ==View.INVISIBLE &&
                btn1.getVisibility() ==View.INVISIBLE &&
                btn2.getVisibility() ==View.INVISIBLE &&
                btn3.getVisibility() ==View.INVISIBLE &&
                btn4.getVisibility() ==View.INVISIBLE &&
                btn5.getVisibility() ==View.INVISIBLE &&
                btn6.getVisibility() ==View.INVISIBLE &&
                btn7.getVisibility() ==View.INVISIBLE &&
                btn8.getVisibility() ==View.INVISIBLE &&
                btn9.getVisibility() ==View.INVISIBLE &&
                btn10.getVisibility() ==View.INVISIBLE &&
                btn11.getVisibility() ==View.INVISIBLE &&
                btn12.getVisibility() ==View.INVISIBLE &&
                btn13.getVisibility() ==View.INVISIBLE &&
                btn14.getVisibility() ==View.INVISIBLE &&
                btn15.getVisibility() ==View.INVISIBLE &&
                btn16.getVisibility() ==View.INVISIBLE &&
                btn17.getVisibility() ==View.INVISIBLE){
            showAnswer();
            tryAgain_btn.setEnabled(false);
            newGame_btn.setEnabled(false);
            endGame_btn.setEnabled(false);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getUserName();
                    newGame_btn.setEnabled(true);
                    endGame_btn.setEnabled(true);
                }
            }, 3000);
        }
    }

    // method: frontOfCardsResources
    // purpose: this method is to set card variable to corresponding image resource
    // Change it depending on size of cards
    private void frontOfCardsResources() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
        image207 = R.drawable.ic_image207;
        image208 = R.drawable.ic_image208;
        image209 = R.drawable.ic_image209;
    }

    // method: showAnswer
    // purpose: this method is to show the answer to each corresponding card
    // Change it depending on size of cards
    private void showAnswer(){
        if(cardsArray[0]==101){
            btn0.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[0]==102){
            btn0.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[0]==103){
            btn0.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[0]==104){
            btn0.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[0]==105){
            btn0.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[0]==106){
            btn0.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[0]==107){
            btn0.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[0]==108){
            btn0.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[0]==109){
            btn0.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[0]==201){
            btn0.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[0]==202){
            btn0.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[0]==203){
            btn0.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[0]==204){
            btn0.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[0]==205){
            btn0.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[0]==206){
            btn0.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[0]==207){
            btn0.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[0]==208){
            btn0.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[0]==209){
            btn0.setImageResource(R.drawable.ic_image209);
        }

        if(cardsArray[1]==101){
            btn1.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[1]==102){
            btn1.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[1]==103){
            btn1.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[1]==104){
            btn1.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[1]==105){
            btn1.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[1]==106){
            btn1.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[1]==107){
            btn1.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[1]==108){
            btn1.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[1]==109){
            btn1.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[1]==110){
            btn1.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[1]==201){
            btn1.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[1]==202){
            btn1.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[1]==203){
            btn1.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[1]==204){
            btn1.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[1]==205){
            btn1.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[1]==206){
            btn1.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[1]==207){
            btn1.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[1]==208){
            btn1.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[1]==209){
            btn1.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[1]==210){
            btn1.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[2]==101){
            btn2.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[2]==102){
            btn2.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[2]==103){
            btn2.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[2]==104){
            btn2.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[2]==105){
            btn2.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[2]==106){
            btn2.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[2]==107){
            btn2.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[2]==108){
            btn2.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[2]==109){
            btn2.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[2]==110){
            btn2.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[2]==201){
            btn2.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[2]==202){
            btn2.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[2]==203){
            btn2.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[2]==204){
            btn2.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[2]==205){
            btn2.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[2]==206){
            btn2.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[2]==207){
            btn2.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[2]==208){
            btn2.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[2]==209){
            btn2.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[2]==210){
            btn2.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[3]==101){
            btn3.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[3]==102){
            btn3.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[3]==103){
            btn3.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[3]==104){
            btn3.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[3]==105){
            btn3.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[3]==106){
            btn3.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[3]==107){
            btn3.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[3]==108){
            btn3.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[3]==109){
            btn3.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[3]==110){
            btn3.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[3]==201){
            btn3.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[3]==202){
            btn3.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[3]==203){
            btn3.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[3]==204){
            btn3.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[3]==205){
            btn3.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[3]==206){
            btn3.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[3]==207){
            btn3.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[3]==208){
            btn3.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[3]==209){
            btn3.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[3]==210){
            btn3.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[4]==101){
            btn4.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[4]==102){
            btn4.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[4]==103){
            btn4.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[4]==104){
            btn4.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[4]==105){
            btn4.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[4]==106){
            btn4.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[4]==107){
            btn4.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[4]==108){
            btn4.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[4]==109){
            btn4.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[4]==110){
            btn4.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[4]==201){
            btn4.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[4]==202){
            btn4.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[4]==203){
            btn4.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[4]==204){
            btn4.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[4]==205){
            btn4.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[4]==206){
            btn4.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[4]==207){
            btn4.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[4]==208){
            btn4.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[4]==209){
            btn4.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[4]==210){
            btn4.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[5]==101){
            btn5.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[5]==102){
            btn5.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[5]==103){
            btn5.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[5]==104){
            btn5.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[5]==105){
            btn5.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[5]==106){
            btn5.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[5]==107){
            btn5.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[5]==108){
            btn5.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[5]==109){
            btn5.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[5]==110){
            btn5.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[5]==201){
            btn5.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[5]==202){
            btn5.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[5]==203){
            btn5.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[5]==204){
            btn5.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[5]==205){
            btn5.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[5]==206){
            btn5.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[5]==207){
            btn5.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[5]==208){
            btn5.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[5]==209){
            btn5.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[5]==210){
            btn5.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[6]==101){
            btn6.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[6]==102){
            btn6.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[6]==103){
            btn6.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[6]==104){
            btn6.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[6]==105){
            btn6.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[6]==106){
            btn6.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[6]==107){
            btn6.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[6]==108){
            btn6.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[6]==109){
            btn6.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[6]==110){
            btn6.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[6]==201){
            btn6.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[6]==202){
            btn6.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[6]==203){
            btn6.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[6]==204){
            btn6.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[6]==205){
            btn6.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[6]==206){
            btn6.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[6]==207){
            btn6.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[6]==208){
            btn6.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[6]==209){
            btn6.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[6]==210){
            btn6.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[7]==101){
            btn7.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[7]==102){
            btn7.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[7]==103){
            btn7.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[7]==104){
            btn7.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[7]==105){
            btn7.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[7]==106){
            btn7.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[7]==107){
            btn7.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[7]==108){
            btn7.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[7]==109){
            btn7.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[7]==110){
            btn7.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[7]==201){
            btn7.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[7]==202){
            btn7.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[7]==203){
            btn7.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[7]==204){
            btn7.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[7]==205){
            btn7.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[7]==206){
            btn7.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[7]==207){
            btn7.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[7]==208){
            btn7.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[7]==209){
            btn7.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[7]==210){
            btn7.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[8]==101){
            btn8.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[8]==102){
            btn8.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[8]==103){
            btn8.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[8]==104){
            btn8.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[8]==105){
            btn8.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[8]==106){
            btn8.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[8]==107){
            btn8.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[8]==108){
            btn8.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[8]==109){
            btn8.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[8]==110){
            btn8.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[8]==201){
            btn8.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[8]==202){
            btn8.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[8]==203){
            btn8.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[8]==204){
            btn8.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[8]==205){
            btn8.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[8]==206){
            btn8.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[8]==207){
            btn8.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[8]==208){
            btn8.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[8]==209){
            btn8.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[8]==210){
            btn8.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[9]==101){
            btn9.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[9]==102){
            btn9.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[9]==103){
            btn9.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[9]==104){
            btn9.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[9]==105){
            btn9.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[9]==106){
            btn9.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[9]==107){
            btn9.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[9]==108){
            btn9.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[9]==109){
            btn9.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[9]==110){
            btn9.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[9]==201){
            btn9.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[9]==202){
            btn9.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[9]==203){
            btn9.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[9]==204){
            btn9.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[9]==205){
            btn9.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[9]==206){
            btn9.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[9]==207){
            btn9.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[9]==208){
            btn9.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[9]==209){
            btn9.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[9]==210){
            btn9.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[10]==101){
            btn10.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[10]==102){
            btn10.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[10]==103){
            btn10.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[10]==104){
            btn10.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[10]==105){
            btn10.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[10]==106){
            btn10.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[10]==107){
            btn10.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[10]==108){
            btn10.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[10]==109){
            btn10.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[10]==110){
            btn10.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[10]==201){
            btn10.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[10]==202){
            btn10.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[10]==203){
            btn10.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[10]==204){
            btn10.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[10]==205){
            btn10.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[10]==206){
            btn10.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[10]==207){
            btn10.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[10]==208){
            btn10.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[10]==209){
            btn10.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[10]==210){
            btn10.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[11]==101){
            btn11.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[11]==102){
            btn11.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[11]==103){
            btn11.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[11]==104){
            btn11.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[11]==105){
            btn11.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[11]==106){
            btn11.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[11]==107){
            btn11.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[11]==108){
            btn11.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[11]==109){
            btn11.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[11]==110){
            btn11.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[11]==201){
            btn11.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[11]==202){
            btn11.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[11]==203){
            btn11.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[11]==204){
            btn11.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[11]==205){
            btn11.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[11]==206){
            btn11.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[11]==207){
            btn11.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[11]==208){
            btn11.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[11]==209){
            btn11.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[11]==210){
            btn11.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[12]==101){
            btn12.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[12]==102){
            btn12.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[12]==103){
            btn12.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[12]==104){
            btn12.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[12]==105){
            btn12.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[12]==106){
            btn12.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[12]==107){
            btn12.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[12]==108){
            btn12.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[12]==109){
            btn12.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[12]==110){
            btn12.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[12]==201){
            btn12.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[12]==202){
            btn12.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[12]==203){
            btn12.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[12]==204){
            btn12.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[12]==205){
            btn12.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[12]==206){
            btn12.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[12]==207){
            btn12.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[12]==208){
            btn12.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[12]==209){
            btn12.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[12]==210){
            btn12.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[13]==101){
            btn13.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[13]==102){
            btn13.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[13]==103){
            btn13.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[13]==104){
            btn13.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[13]==105){
            btn13.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[13]==106){
            btn13.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[13]==107){
            btn13.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[13]==108){
            btn13.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[13]==109){
            btn13.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[13]==110){
            btn13.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[13]==201){
            btn13.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[13]==202){
            btn13.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[13]==203){
            btn13.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[13]==204){
            btn13.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[13]==205){
            btn13.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[13]==206){
            btn13.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[13]==207){
            btn13.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[13]==208){
            btn13.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[13]==209){
            btn13.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[13]==210){
            btn13.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[14]==101){
            btn14.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[14]==102){
            btn14.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[14]==103){
            btn14.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[14]==104){
            btn14.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[14]==105){
            btn14.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[14]==106){
            btn14.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[14]==107){
            btn14.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[14]==108){
            btn14.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[14]==109){
            btn14.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[14]==110){
            btn14.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[14]==201){
            btn14.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[14]==202){
            btn14.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[14]==203){
            btn14.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[14]==204){
            btn14.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[14]==205){
            btn14.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[14]==206){
            btn14.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[14]==207){
            btn14.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[14]==208){
            btn14.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[14]==209){
            btn14.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[14]==210){
            btn14.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[15]==101){
            btn15.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[15]==102){
            btn15.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[15]==103){
            btn15.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[15]==104){
            btn15.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[15]==105){
            btn15.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[15]==106){
            btn15.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[15]==107){
            btn15.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[15]==108){
            btn15.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[15]==109){
            btn15.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[15]==110){
            btn15.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[15]==201){
            btn15.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[15]==202){
            btn15.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[15]==203){
            btn15.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[15]==204){
            btn15.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[15]==205){
            btn15.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[15]==206){
            btn15.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[15]==207){
            btn15.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[15]==208){
            btn15.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[15]==209){
            btn15.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[15]==210){
            btn15.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[16]==101){
            btn16.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[16]==102){
            btn16.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[16]==103){
            btn16.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[16]==104){
            btn16.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[16]==105){
            btn16.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[16]==106){
            btn16.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[16]==107){
            btn16.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[16]==108){
            btn16.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[16]==109){
            btn16.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[16]==110){
            btn16.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[16]==201){
            btn16.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[16]==202){
            btn16.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[16]==203){
            btn16.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[16]==204){
            btn16.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[16]==205){
            btn16.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[16]==206){
            btn16.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[16]==207){
            btn16.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[16]==208){
            btn16.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[16]==209){
            btn16.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[16]==210){
            btn16.setImageResource(R.drawable.ic_image210);
        }

        if(cardsArray[17]==101){
            btn17.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[17]==102){
            btn17.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[17]==103){
            btn17.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[17]==104){
            btn17.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[17]==105){
            btn17.setImageResource(R.drawable.ic_image105);
        }else if(cardsArray[17]==106){
            btn17.setImageResource(R.drawable.ic_image106);
        }else if(cardsArray[17]==107){
            btn17.setImageResource(R.drawable.ic_image107);
        }else if(cardsArray[17]==108){
            btn17.setImageResource(R.drawable.ic_image108);
        }else if(cardsArray[17]==109){
            btn17.setImageResource(R.drawable.ic_image109);
        }else if(cardsArray[17]==110){
            btn17.setImageResource(R.drawable.ic_image110);
        }else if(cardsArray[17]==201){
            btn17.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[17]==202){
            btn17.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[17]==203){
            btn17.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[17]==204){
            btn17.setImageResource(R.drawable.ic_image204);
        }else if(cardsArray[17]==205){
            btn17.setImageResource(R.drawable.ic_image205);
        }else if(cardsArray[17]==206){
            btn17.setImageResource(R.drawable.ic_image206);
        }else if(cardsArray[17]==207){
            btn17.setImageResource(R.drawable.ic_image207);
        }else if(cardsArray[17]==208){
            btn17.setImageResource(R.drawable.ic_image208);
        }else if(cardsArray[17]==209){
            btn17.setImageResource(R.drawable.ic_image209);
        }else if(cardsArray[17]==210){
            btn17.setImageResource(R.drawable.ic_image210);
        }


        btn0.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        btn9.setVisibility(View.VISIBLE);
        btn10.setVisibility(View.VISIBLE);
        btn11.setVisibility(View.VISIBLE);
        btn12.setVisibility(View.VISIBLE);
        btn13.setVisibility(View.VISIBLE);
        btn14.setVisibility(View.VISIBLE);
        btn15.setVisibility(View.VISIBLE);
        btn16.setVisibility(View.VISIBLE);
        btn17.setVisibility(View.VISIBLE);
    }

    // method: play
    // purpose: this method is to create and play music, it gets destroyed when Activity is completed
    // No need to change
    public void play(){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.music8);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    // method: pause
    // purpose: this method is to pause the music
    // No need to change
    public void pause(){
        if(player != null){
            player.pause();
        }
    }

    // method: stop
    // purpose: this method is to stop the music by stopPlayer method
    // No need to change
    public void stop(){
        stopPlayer();
    }

    // method: stop
    // purpose: this method is to stop the music by setting player to null
    // No need to change
    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    // method: onStop
    // purpose: this method is to stop the music when player is stopped
    // No need to change
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    // method: readFromFile
    // purpose: this method is to read the data from internal storage
    // No need to change
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

    // method: writeToFile
    // purpose: this method is to write the data into internal storage by accepting filename and data
    // No need to change
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

    // method: updateScoreBoard
    // purpose: this method is to write the new score data into internal storage by using writeToFile method
    // Change it depending on which level
    public void updateScoreBoard(){
        if(points> score1){
            //write initials
            writeToFile("level18_init1.txt",userName_string);
            //write scores
            writeToFile("level18_sc1.txt",String.valueOf(points));
        }else if(points> score2){
            //write initials
            writeToFile("level18_init2.txt",userName_string);
            //write scores
            writeToFile("level18_sc2.txt",String.valueOf(points));
        }else if(points> score3){
            //write initials
            writeToFile("level18_init3.txt",userName_string);
            //write scores
            writeToFile("level18_sc3.txt",String.valueOf(points));
        }
    }

    // method: getUserName
    // purpose: this method is to show final score and get user name by using dialogue
    // Change it depending on which Activity
    public void getUserName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game18_Activity.this);
        alert.setTitle("GAME OVER!\nScore: " + points);
        alert.setMessage("Please enter 3 initials, if Cancel clicked, it's set to zzz.\nIf you don't enter anything and Ok clicked, score will not be saved.");
        // Set an EditText view to get user input
        final EditText input = new EditText(Game18_Activity.this);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = String.valueOf(input.getText());
                // Do something with value!
                String temp ="";
                for (int i = 0; i < 3; i++) {
                    temp += value.charAt(i);
                }
                userName_string = temp;
                updateScoreBoard();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
                userName_string = "zzz";
                updateScoreBoard();
            }
        });
        alert.show();
    }

    // method: gameExplanation
    // purpose: this method is to show the rules for the game by using dialogue
    // Change it depending on which Activity
    public void gameExplanation(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game18_Activity.this);
        alert.setTitle("Basic Rules");
        alert.setMessage("*Correct match +2pts.\n*Wrong match -1pts.\n*Click try again btn to flip the card back to original.\n*Click play btn to start background music." +
                "\n*Click pause btn to pause the music.\n*Click new game btn to start new game.\n*Click end game btn to end the game." +
                "\n\n*Be aware that there is few seconds of delay between actions\n*If any error happens, click try again btn and re-try to click the images.");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    // method: onOptionsItemSelected
    // purpose: this method is overwritten to have correct up button function
    // Change it depending on which Activity
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                stop();
                startActivity(new Intent(Game18_Activity.this,MainActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}