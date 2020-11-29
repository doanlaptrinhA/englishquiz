package com.son.englishtest100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.Cursor;

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

        Data.QueryData("DROP TABLE IF EXISTS QuizScore");
        Data.QueryData("CREATE TABLE IF NOT EXISTS QuizScore(STT INTEGER PRIMARY KEY AUTOINCREMENT, ID STRING, Level STRING, Score STRING);");
        Data.QueryData("INSERT INTO QuizScore(ID,Level,Score) VALUES" + "('" + test + "','" + test2 + "','" + total2 + "');");

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, Menu.class);
                startActivity(intent);
            }
        });
    }


}