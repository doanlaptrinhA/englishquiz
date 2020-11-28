package com.son.englishtest100;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Choose extends AppCompatActivity {
    TextView  txt5q, txt10q;
    ImageView nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txt5q = findViewById(R.id.txt5q);
        txt10q = findViewById(R.id.txt10q);
        nextbtn = findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,Level.class);
                startActivity(intent);
            }

        });
        txt5q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose.this,Level.class);
                startActivity(intent);
            }
        });
//        txt5q.setOnTouchListener (new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                MediaPlayer mp = MediaPlayer.create(Choose.this,R.raw.music2);
//                mp.start();
//                return false;
//            }
//        });
//
//        txt10q.setOnTouchListener (new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                MediaPlayer mp = MediaPlayer.create(Choose.this,R.raw.music2);
//                mp.start();
//                return false;
//            }
//        });
    }
}
