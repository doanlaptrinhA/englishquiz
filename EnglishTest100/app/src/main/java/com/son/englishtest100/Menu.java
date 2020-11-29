package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
    ImageView buttonTest, buttonRank, buttonReturnLogin, buttonManual, QuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonTest = findViewById(R.id.buttonTest);
        buttonRank = findViewById(R.id.buttonRank);
        buttonManual = findViewById(R.id.buttonmManual);
        buttonReturnLogin = findViewById(R.id.buttonReturnLogin);
        QuestionButton= findViewById(R.id.QuestionButton);

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Level.class);
                startActivity(intent);
            }
        });
        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Rank.class);
                startActivity(intent);
            }
        });
        buttonRank.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Menu.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        buttonManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Rank.class);
                startActivity(intent);
            }
        });
        buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Welcome.class);
                startActivity(intent);
            }
        });
        buttonReturnLogin.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Menu.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        QuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Instruction.class);
                startActivity(intent);
            }
        });
        QuestionButton.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Menu.this,R.raw.click);
                mp.start();
                return false;
            }
        });
    }

}