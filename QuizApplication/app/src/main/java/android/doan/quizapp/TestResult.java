package android.doan.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestResult extends AppCompatActivity {
    Button btnEnd, btnTest;
    TextView textName, textLevel, textResult, textTotal;
    DatabaseHelper Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_result);

        btnEnd = findViewById(R.id.buttonEnd);
        textName = findViewById(R.id.textName);
        textLevel = findViewById(R.id.textLevel);
        textResult = findViewById(R.id.textResult);
        textTotal = findViewById(R.id.totaltxt);
        btnTest = findViewById(R.id.btnTest);

        Data = new DatabaseHelper(this, "Data.sqlite", null, 2);
        final MediaPlayer mp = MediaPlayer.create(TestResult.this, R.raw.success_sound);
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

        Data.QueryData("CREATE TABLE IF NOT EXISTS QuizScore(STT INTEGER PRIMARY KEY AUTOINCREMENT, ID STRING,Level STRING, Score FLOAT);");
        Data.QueryData("INSERT INTO QuizScore(ID,Level,Score) VALUES" + "('" + test + "','" + test2 + "','" + total2 + "');");


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestResult.this, QuizDashboard.class);
                startActivity(intent);
                Data.close();
            }
        });

        //AskedQuestion
        Intent list = getIntent();
        Bundle packagefromCaller2 = list.getBundleExtra("QuestionDatabase");
        List<String> listCollection = new ArrayList<String>();

        //GetAskedQuestion
        ArrayList listAskedQuestion;
        listAskedQuestion = packagefromCaller2.getParcelableArrayList("askedlist");
        //GetCorrectAnswer
        ArrayList listAskedCorrectAnswer;
        listAskedCorrectAnswer = packagefromCaller2.getParcelableArrayList("correct");
        //GetYourAnswer
        ArrayList listAskedYourAnswer;
        listAskedYourAnswer = packagefromCaller2.getParcelableArrayList("answered");

        for (int i = 0; i < listAskedQuestion.size(); i++) {
            String question = listAskedQuestion.get(i).toString();
            String correct = listAskedCorrectAnswer.get(i).toString();
            String ans = listAskedYourAnswer.get(i).toString();
            String mixed = "QuestionDatabase " + (i + 1) + ": " + question + "\n" + "Correct Answer: " + correct + "\n" + "Your Answer: " + ans + "\n";
            listCollection.add(mixed);
        }

        //LoadToDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(TestResult.this);
        builder.setTitle("Detailed Results Table");
        String[] items = listCollection.toArray(new String[0]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

            }
        });
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                dialog.dismiss();
            }
        });
        final Dialog dialog = builder.create();


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }


}