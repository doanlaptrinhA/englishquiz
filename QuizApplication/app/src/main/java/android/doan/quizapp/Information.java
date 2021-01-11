package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    TextView txtName, txtUsernameID;
    ImageView next;
    Button buttonLogin, buttonLessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_information);

        next = findViewById(R.id.next);
        txtName = findViewById(R.id.Name);
        txtUsernameID = findViewById(R.id.UsernameID);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLessons = findViewById(R.id.buttonLessons);

        SharedPreferences sharedPreferences2 = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        final String loadid = sharedPreferences2.getString("ID", null);
        final String loadname = sharedPreferences2.getString("Name", null);
        txtName.setText(loadname);
        txtUsernameID.setText(loadid);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, QuizDashboard.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, LoadingWelcome.class);
                startActivity(intent);
            }
        });

        buttonLessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, LessonsMenu.class);
                startActivity(intent);
            }
        });
    }

}