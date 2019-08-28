package com.example.whichnumberisbigger;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private BiggerNumberGame game;
    private ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background=findViewById(R.id.constraint_layout_main);

        wireWidgets();
        setListeners();
       // construct the game
        game = new BiggerNumberGame(0,1000000);
        updateGameDisplay();
    }

    private void changeBackGround(int x, int y) {
        int color = Color.rgb(x , y , 0);
        background.setBackgroundColor(color);


    }


    private void updateGameDisplay() {
        // set the text of each button
        game.generateRandomNumbers();
       buttonLeft.setText(String.valueOf(game.getNumber1()));
       buttonRight.setText(String.valueOf(game.getNumber2()));

        // set the text of the score
        textViewScore.setText(String.valueOf(game.getScore()));

    }

    private void setListeners() {
        // creating an Anonymous Inner Class that implements View.OnClick Listener
        // overriding the one abstract method onClick(View v)
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(buttonLeft.getText().toString());
                String message = game.checkAnswer(answer);
                if (game.getCorrect() == 1)
                {changeBackGround(0,255);}
                else {changeBackGround(255,0);}
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();

                updateGameDisplay();
            }

        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = Integer.parseInt(buttonRight.getText().toString());
                String message = game.checkAnswer(answer);
                if (game.getCorrect() == 1)
                {changeBackGround(0,255);}
                else {changeBackGround(255,0);}
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                updateGameDisplay();
            }

        });
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight= findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.texview_main_score);
    }
}
