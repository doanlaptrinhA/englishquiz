package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Random extends AppCompatActivity{
    ArrayList<Question> listQuestion = new ArrayList<>();
    ArrayList<Question> randomQuestion = new ArrayList<>();
    TextView click10q;
    TextView click5q;
    ArrayList<String> number = new ArrayList<String>();
    Question item;
    String level;
    ImageView nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosequestion);

        click5q =  findViewById(R.id.txt5q);
        click10q = findViewById(R.id.txt10q);
        nextbtn = findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Random.this,Level.class);
                startActivity(intent);
            }

        });
        Intent callerIntent = getIntent();
        final Bundle bundle = callerIntent.getBundleExtra("QuestionList");
        final ArrayList<Question> listQuestion = (ArrayList<Question>) bundle.getSerializable("ArrayList");
        level = callerIntent.getStringExtra("level");

        click5q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Random.this,Test.class);
                Bundle array = new Bundle();
                Bundle dataTest = new Bundle();
                randomQuestion = getRandom(listQuestion,5,item);
                sendData(level,"5",randomQuestion,intent,array,dataTest);
                sendDataResult(level);
            }
        });


        click10q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Random.this,Test.class);
                Bundle array = new Bundle();
                Bundle dataTest = new Bundle();
                randomQuestion = getRandom(listQuestion,10,item);
                sendData(level,"10",randomQuestion,intent,array,dataTest);
                sendDataResult(level);
            }
        });
    }

    public  static ArrayList  getRandom(ArrayList<Question> listQuestion,int number, Question item){
        java.util.Random random = new java.util.Random();
        ArrayList<Question> randomQuestion = new ArrayList<>();

        for(int i=0; i<number;i++){
            item = listQuestion.get(random.nextInt(number));
            randomQuestion.add(item);
        }
        return randomQuestion;
    }


    public void sendData(String level, String soCauHoi, ArrayList<Question> randomQuestion,Intent intent, Bundle bundle1, Bundle bundle2){
        bundle1.putSerializable("RandomArrayList",(Serializable)randomQuestion);
        bundle2.putString("level",level);
        bundle2.putString("soCauHoi",soCauHoi);
        intent.putExtra("dataTest",bundle2);
        intent.putExtra("RandomQuestionList",bundle1);
        startActivity(intent);
    }


    public void sendDataResult(String level){
        SharedPreferences sharedPreferences = getSharedPreferences("LevelData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LevelResult",level);
        editor.apply();
    }

}