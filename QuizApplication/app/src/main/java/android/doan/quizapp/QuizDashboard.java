package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.content.DialogInterface;

public class QuizDashboard extends AppCompatActivity {
    ImageView buttonTest, buttonRank, buttonReturnLogin,QuestionButton,AccountButton;
    MediaPlayer mp;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_dashboard);

        buttonTest = findViewById(R.id.buttonTest);
        buttonRank = findViewById(R.id.buttonRank);
        buttonReturnLogin = findViewById(R.id.buttonReturnLogin);
        QuestionButton= findViewById(R.id.QuestionButton);
        AccountButton = findViewById(R.id.AccountButton);

        mp = MediaPlayer.create(QuizDashboard.this,R.raw.music8);
        mp.start();
        mp.setLooping(true);

        //Click
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(QuizDashboard.this, LoadingLevel.class);
                startActivity(intent);
            }
        });

        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(QuizDashboard.this, QuizRank.class);
                startActivity(intent);
            }
        });


        buttonReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(QuizDashboard.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit ??");
                builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                        dialogInterface.dismiss();
                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        QuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(QuizDashboard.this,Instruction.class);
                startActivity(intent);
            }
        });
        AccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(QuizDashboard.this, Information.class);
                startActivity(intent);
            }
        });

        //Sound
        buttonRank.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizDashboard.this,R.raw.click);
                mp.start();
                return false;
            }
        });

        buttonReturnLogin.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizDashboard.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        buttonTest.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizDashboard.this,R.raw.click);
                mp.start();
                return false;
            }
        });

        QuestionButton.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizDashboard.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        AccountButton.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(QuizDashboard.this,R.raw.click);
                mp.start();
                return false;
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
        length = mp.getCurrentPosition();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.seekTo(length);
        mp.start();
        mp.setLooping(true);
    }


}