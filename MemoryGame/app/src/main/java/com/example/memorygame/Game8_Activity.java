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

public class Game8_Activity extends AppCompatActivity {

    //Declarations(Change it depending on size of cards)
    ImageView btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Button play_btn, pause_btn,tryAgain_btn,newGame_btn,endGame_btn;
    MediaPlayer player;
    TextView score;

    //Array for 8 images(Change it depending on size of cards)
    Integer[] cardsArray = {101,102,103,104,201,202,203,204};
    //Actual images
    int image101,image102,image103,image104,image201,image202,image203,image204;

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
        setContentView(R.layout.activity_game8);

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

        //reading the score data from internal storage(Change it depending on level)
        //Change it depending on which level
        stringScore1 = readFromFile("level8_sc1.txt");
        stringScore2 = readFromFile("level8_sc2.txt");
        stringScore3 = readFromFile("level8_sc3.txt");
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
                        startActivity(new Intent(Game8_Activity.this,MainActivity.class));
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
                startActivity(new Intent(Game8_Activity.this,Game8_Activity.class));
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
        } else if(cardsArray[card] == 201){
            btn.setImageResource(image201);
        } else if(cardsArray[card] == 202){
            btn.setImageResource(image202);
        } else if(cardsArray[card] == 203){
            btn.setImageResource(image203);
        } else if(cardsArray[card] == 204){
            btn.setImageResource(image204);
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

        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
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
                btn7.getVisibility() ==View.INVISIBLE){
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
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
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
        }else if(cardsArray[0]==201){
            btn0.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[0]==202){
            btn0.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[0]==203){
            btn0.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[0]==204){
            btn0.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[1]==101){
            btn1.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[1]==102){
            btn1.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[1]==103){
            btn1.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[1]==104){
            btn1.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[1]==201){
            btn1.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[1]==202){
            btn1.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[1]==203){
            btn1.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[1]==204){
            btn1.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[2]==101){
            btn2.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[2]==102){
            btn2.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[2]==103){
            btn2.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[2]==104){
            btn2.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[2]==201){
            btn2.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[2]==202){
            btn2.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[2]==203){
            btn2.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[2]==204){
            btn2.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[3]==101){
            btn3.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[3]==102){
            btn3.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[3]==103){
            btn3.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[3]==104){
            btn3.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[3]==201){
            btn3.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[3]==202){
            btn3.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[3]==203){
            btn3.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[3]==204){
            btn3.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[4]==101){
            btn4.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[4]==102){
            btn4.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[4]==103){
            btn4.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[4]==104){
            btn4.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[4]==201){
            btn4.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[4]==202){
            btn4.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[4]==203){
            btn4.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[4]==204){
            btn4.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[5]==101){
            btn5.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[5]==102){
            btn5.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[5]==103){
            btn5.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[5]==104){
            btn5.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[5]==201){
            btn5.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[5]==202){
            btn5.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[5]==203){
            btn5.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[5]==204){
            btn5.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[6]==101){
            btn6.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[6]==102){
            btn6.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[6]==103){
            btn6.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[6]==104){
            btn6.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[6]==201){
            btn6.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[6]==202){
            btn6.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[6]==203){
            btn6.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[6]==204){
            btn6.setImageResource(R.drawable.ic_image204);
        }

        if(cardsArray[7]==101){
            btn7.setImageResource(R.drawable.ic_image101);
        }else if(cardsArray[7]==102){
            btn7.setImageResource(R.drawable.ic_image102);
        }else if(cardsArray[7]==103){
            btn7.setImageResource(R.drawable.ic_image103);
        }else if(cardsArray[7]==104){
            btn7.setImageResource(R.drawable.ic_image104);
        }else if(cardsArray[7]==201){
            btn7.setImageResource(R.drawable.ic_image201);
        }else if(cardsArray[7]==202){
            btn7.setImageResource(R.drawable.ic_image202);
        }else if(cardsArray[7]==203){
            btn7.setImageResource(R.drawable.ic_image203);
        }else if(cardsArray[7]==204){
            btn7.setImageResource(R.drawable.ic_image204);
        }

        btn0.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
    }

    // method: play
    // purpose: this method is to create and play music, it gets destroyed when Activity is completed
    // No need to change
    public void play(){
        if(player == null){
            player = MediaPlayer.create(this, R.raw.music3);
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
            writeToFile("level8_init1.txt",userName_string);
            //write scores
            writeToFile("level8_sc1.txt",String.valueOf(points));
        }else if(points> score2){
            //write initials
            writeToFile("level8_init2.txt",userName_string);
            //write scores
            writeToFile("level8_sc2.txt",String.valueOf(points));
        }else if(points> score3){
            //write initials
            writeToFile("level8_init3.txt",userName_string);
            //write scores
            writeToFile("level8_sc3.txt",String.valueOf(points));
        }
    }

    // method: getUserName
    // purpose: this method is to show final score and get user name by using dialogue
    // Change it depending on which Activity
    public void getUserName(){
        AlertDialog.Builder alert = new AlertDialog.Builder(Game8_Activity.this);
        alert.setTitle("GAME OVER!\nScore: " + points);
        alert.setMessage("Please enter 3 initials, if Cancel clicked, it's set to zzz.\nIf you don't enter anything and Ok clicked, score will not be saved.");
        // Set an EditText view to get user input
        final EditText input = new EditText(Game8_Activity.this);
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
        AlertDialog.Builder alert = new AlertDialog.Builder(Game8_Activity.this);
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
                startActivity(new Intent(Game8_Activity.this,MainActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}