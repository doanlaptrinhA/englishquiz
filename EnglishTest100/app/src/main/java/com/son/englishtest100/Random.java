package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Random extends AppCompatActivity{
    ArrayList<Question> listQuestion = new ArrayList<>();
    ArrayList<Question> randomQuestion = new ArrayList<>();
    Button buttonOk;
    Spinner spinnerRandom;
    ArrayList<String> number = new ArrayList<String>();
    Question item;
    String level;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosequestion);

        buttonOk = findViewById(R.id.buttonOk);
        spinnerRandom = findViewById(R.id.spinnerRandom);

        createDropdown(number,spinnerRandom);
        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("QuestionList");
        final ArrayList<Question> listQuestion = (ArrayList<Question>) bundle.getSerializable("ArrayList");
        level = callerIntent.getStringExtra("level");

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Random.this,Test.class);
                Bundle array = new Bundle();
                Bundle dataTest = new Bundle();
                
                if(spinnerRandom.getSelectedItem().toString()=="5"){
                    randomQuestion = getRandom(listQuestion,5,item);
                    sendData(level,"5",randomQuestion,intent,array,dataTest);

                }else if(spinnerRandom.getSelectedItem().toString()=="6"){
                    randomQuestion = getRandom(listQuestion,6,item);
                    sendData(level,"6",randomQuestion,intent,array,dataTest);

                }else if(spinnerRandom.getSelectedItem().toString()=="7"){
                    randomQuestion = getRandom(listQuestion,7,item);
                    sendData(level,"7",randomQuestion,intent,array,dataTest);

                }else if(spinnerRandom.getSelectedItem().toString()=="8"){
                    randomQuestion = getRandom(listQuestion,8,item);
                    sendData(level,"8",randomQuestion,intent,array,dataTest);

                }else if(spinnerRandom.getSelectedItem().toString()=="9"){
                    randomQuestion = getRandom(listQuestion,9,item);
                    sendData(level,"9",randomQuestion,intent,array,dataTest);

                }else if(spinnerRandom.getSelectedItem().toString()=="10"){
                    randomQuestion = getRandom(listQuestion,10,item);
                    sendData(level,"10",randomQuestion,intent,array,dataTest);
                }
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
    public  void createDropdown(ArrayList number, Spinner spinnerRandom){
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        ArrayAdapter<String> adapternumber = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, number);
        adapternumber.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerRandom.setAdapter(adapternumber);
    }
}