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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;

public class Game12_Activity extends AppCompatActivity {

    //Declarations(Change it depending on size of cards)
    ImageView btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
    Button play_btn, pause_btn,tryAgain_btn,newGame_btn,endGame_btn;
    MediaPlayer player;
    TextView score;

    //Array for 12 images(Change it depending on size of cards)
    Integer[] cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};
    //Actual images
    int image101,image102,image103,image104,image105,image106,image201,image202,image203,image204,image205,image206;

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
        setContentView(R.layout.activity_game12);

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

        //reading the score data from internal storage(Change it depending on level)
        //Change it depending on which level
        stringScore1 = readFromFile("level12_sc1.txt");
        stringScore2 = readFromFile("level12_sc2.txt");
        stringScore3 = readFromFile("level12_sc3.txt");
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
                        if(!userName_string.equals("")){
                            updateScoreBoard();
                        }
                        stop();
                        startActivity(new Intent(Game12_Activity.this,MainActivity.class));
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
                if(!userName_string.equals("")){
                    updateScoreBoard();
                }
                stop();
                startActivity(new Intent(Game12_Activity.this,Game12_Activity.class));
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
        } else if(cardsArray[card] == 201){
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
                btn11.getVisibility() ==View.INVISIBLE){
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
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
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
    }

    // method: play
    // purpose: this method is to create and play music, it gets destroyed when Activity is completed
    // No need to change
    public void play(){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.music5);
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
            writeToFile("level12_init1.txt",userName_string);
            //write scores
            writeToFile("level12_sc1.txt",String.valueOf(points));
        }else if(points> score2){
            //write initials
            writeToFile("level12_init2.txt",userName_string);
            //write scores
            writeToFile("level12_sc2.txt",String.valueOf(points));
        }else if(points> score3){
            //write initials
            writeToFile("level12_init3.txt",userName_string);
            //write scores
            writeToFile("level12_sc3.txt",String.valueOf(points));
        }
    }

    // method: getUserName
    // purpose: this method is to show final score and get user name by using dialogue
    // Change it depending on which Activity
    public void getUserName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game12_Activity.this);
        alert.setTitle("GAME OVER!\nScore: " + points);
        alert.setMessage("Please enter 3 initials, if Cancel clicked, it's set to zzz.\nIf you don't enter anything and Enter clicked, score will not be saved.");
        // Set an EditText view to get user input
        final EditText input = new EditText(Game12_Activity.this);
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

    // method: gameExplanation
    // purpose: this method is to show the rules for the game by using dialogue
    // Change it depending on which Activity
    public void gameExplanation(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game12_Activity.this);
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


}