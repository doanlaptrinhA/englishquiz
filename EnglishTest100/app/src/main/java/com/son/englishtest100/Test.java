package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
>>>>>>> a31e62659ed9602e198558efbfa76878dc7f3ad1
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Test extends AppCompatActivity{
    TextView textDokho, textSocauhoi, textCauhoi;
    RadioGroup RG;
    RadioButton optA, optB, optC, optD;
    ImageView nextBtn;
    ArrayList<Question> test = new ArrayList<>();
    int pos=0;
    int ketqua = 0;
    int HighScore=0;
    SoundPool soundPool;
    private static MediaPlayer MediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textDokho = findViewById(R.id.textDokho);
        textSocauhoi = findViewById(R.id.textSocauhoi);
        textCauhoi = findViewById(R.id.textCauhoi);
        nextBtn = findViewById(R.id.buttonNext);
        RG = findViewById(R.id.radioGroup);
        optA = findViewById(R.id.radioButtonA);
        optB = findViewById(R.id.radioButtonB);
        optC = findViewById(R.id.radioButtonC);
        optD = findViewById(R.id.radioButtonD);

        textDokho.setText(getIntent().getBundleExtra("dataTest").getString("level"));
        textSocauhoi.setText(getIntent().getBundleExtra("dataTest").getString("soCauHoi"));

        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("RandomQuestionList");
        test = (ArrayList<Question>) bundle.getSerializable("RandomArrayList");

//        LoadHighScore();
        Display(pos);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idCheck = RG.getCheckedRadioButtonId();
                switch (idCheck) {
                    case R.id.radioButtonA:
                        if (test.get(pos).Answer.compareTo("A") == 0) ketqua = ketqua + 1;
                        break;
                    case R.id.radioButtonB:
                        if (test.get(pos).Answer.compareTo("B") == 0) ketqua = ketqua + 1;
                        break;
                    case R.id.radioButtonC:
                        if (test.get(pos).Answer.compareTo("C") == 0) ketqua = ketqua + 1;
                        break;
                    case R.id.radioButtonD:
                        if (test.get(pos).Answer.compareTo("D") == 0) ketqua = ketqua + 1;
                        break;
                }
                pos++;
                if (pos >= test.size() ){
                    Intent intent = new Intent(Test.this, Result.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KQ", ketqua);
                    bundle.putInt("Socau", pos);
                    intent.putExtra("MyPackage", bundle);
                    startActivity(intent);

                    finish();
                } else Display(pos);
            }
        });


        optA.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Test.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        optB.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Test.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        optC.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Test.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        optD.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Test.this,R.raw.click);
                mp.start();
                return false;
            }
        });
        nextBtn.setOnTouchListener (new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(Test.this,R.raw.click);
                mp.start();
                return false;
            }
        });

    }
    void Display(int i){
        textCauhoi.setText(test.get(i).CauHoi);
        optA.setText(test.get(i).AnswerA);
        optB.setText(test.get(i).AnswerB);
        optC.setText(test.get(i).AnswerC);
        optD.setText(test.get(i).AnswerD);
        RG.clearCheck();
    }
//    void LoadHighScore(){
//        SharedPreferences sharedPreferences = getSharedPreferences("MyData",
//                Context.MODE_PRIVATE);
//        if (sharedPreferences !=null){
//            HighScore = sharedPreferences.getInt("H",0);
//        }
//    }
//    void SaveHighScore(){
//        SharedPreferences sharedPreferences = getSharedPreferences("MyData",Context.MODE_PRIVATE);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////        editor.putInt("H",HighScore);
////        editor.apply();
//    }
}