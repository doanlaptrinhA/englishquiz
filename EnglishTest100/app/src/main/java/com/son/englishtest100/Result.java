package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button btnEnd;
    TextView textName, textLevel, textResult, textTotal;
    Database Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnEnd = findViewById(R.id.buttonEnd);
        textName = findViewById(R.id.textName);
        textLevel = findViewById(R.id.textLevel);
        textResult = findViewById(R.id.textResult);
        textTotal = findViewById(R.id.totaltxt);

        Data = new Database(this, "Data.sqlite", null, 2);
        final MediaPlayer mp = MediaPlayer.create(Result.this,R.raw.success_sound);
        mp.start();

        //LoadKQ
        Intent callerIntent = getIntent();
        final Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage");
        textResult.setText(packageFromCaller.getInt("KQ") + "/" + packageFromCaller.getInt("Socau"));

        //LoadName
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String test = sharedPreferences.getString("Name", null);
        textName.setText(test);

        //LoadLevel
        SharedPreferences sharedPreferences2 = getSharedPreferences("LevelData", Context.MODE_PRIVATE);
        final String test2 = sharedPreferences2.getString("LevelResult", null);
        textLevel.setText(test2);

        //Score
        double total = packageFromCaller.getInt("KQ");
        final double total2;
        if (test2.equals("Medium")) {
            total2 = total * 1.5;
        } else if (test2.equals("Hard")) {
            total2 = total * 2;
        } else {
            total2 = total;
        }
        textTotal.setText(Double.toString(total2));

        Data.QueryData("CREATE TABLE IF NOT EXISTS QuizScore(STT INTEGER PRIMARY KEY AUTOINCREMENT, ID STRING, Level STRING, Score FLOAT);");
        Data.QueryData("INSERT INTO QuizScore(ID,Level,Score) VALUES" + "('" + test + "','" + test2 + "','" + total2 + "');");
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, Menu.class);
                startActivity(intent);
                Data.close();
            }
        });

    }

//    @Override
//    protected void onStop () {
//        super.onStop();
//        SharedPreferences sharedPreferences2 = getSharedPreferences("Insert", Context.MODE_PRIVATE);
//        final String test = sharedPreferences2.getString("test", null);
//        final String test2 = sharedPreferences2.getString("test2", null);
//        final String total2 = sharedPreferences2.getString("total2", null);
//
//    }
//
//    public void SaveDB(String test,String test2,String total2){
//        SharedPreferences sharedPreferences = getSharedPreferences("Insert", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("test",test);
//        editor.putString("test2",test2);
//        editor.putString("total2",total2);
//        editor.apply();
//    }

}