package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class LoadingQuestions extends AppCompatActivity{
    ArrayList<QuestionDatabase> listQuestionDatabase = new ArrayList<>();
    ArrayList<QuestionDatabase> randomQuestionDatabase = new ArrayList<>();
    Button click10q,click5q;
    ArrayList<String> number = new ArrayList<String>();
    QuestionDatabase item;
    String level;
    ImageView nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_choosequestions);

        click5q =  findViewById(R.id.btnFive);
        click10q = findViewById(R.id.btnTen);
        nextbtn = findViewById(R.id.nextbtn);

        nextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingQuestions.this, LoadingLevel.class);
                startActivity(intent);
            }

        });

        Intent callerIntent = getIntent();
        final Bundle bundle = callerIntent.getBundleExtra("QuestionList");
        final ArrayList<QuestionDatabase> listQuestionDatabase = (ArrayList<QuestionDatabase>) bundle.getSerializable("ArrayList");
        level = callerIntent.getStringExtra("level");

        click5q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingQuestions.this, QuizTest.class);
                Bundle array = new Bundle();
                Bundle dataTest = new Bundle();
                randomQuestionDatabase = getRandom(listQuestionDatabase,5,item);
                sendData(level,"5", randomQuestionDatabase,intent,array,dataTest);
                sendDataResult(level);
            }
        });


        click10q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingQuestions.this, QuizTest.class);
                Bundle array = new Bundle();
                Bundle dataTest = new Bundle();
                randomQuestionDatabase = getRandom(listQuestionDatabase,10,item);
                sendData(level,"10", randomQuestionDatabase,intent,array,dataTest);
                sendDataResult(level);
            }
        });
    }


    public ArrayList  getRandom(ArrayList<QuestionDatabase> listQuestionDatabase, int number, QuestionDatabase item){
        java.util.Random random = new java.util.Random();
        ArrayList<QuestionDatabase> randomQuestionDatabase = new ArrayList<>();
        for(int i=0; i<number;i++) {
            Collections.shuffle(listQuestionDatabase);
            item = listQuestionDatabase.get(random.nextInt(number));
                if (item.CauHoi.contains(item.CauHoi))
                {
                    listQuestionDatabase.remove(item);
                }
                randomQuestionDatabase.add(item);
            }
        return randomQuestionDatabase;
    }


    public void sendData(String level, String soCauHoi, ArrayList<QuestionDatabase> randomQuestionDatabase, Intent intent, Bundle bundle1, Bundle bundle2){
        bundle1.putSerializable("RandomArrayList",(Serializable) randomQuestionDatabase);
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