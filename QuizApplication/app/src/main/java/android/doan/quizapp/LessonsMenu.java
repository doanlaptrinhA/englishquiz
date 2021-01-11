package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LessonsMenu extends AppCompatActivity {
    Button buttonGrammar, buttonVocabulary, buttonSpeaking, buttonTrick;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_lessons_menu);

        next = findViewById(R.id.next);
        buttonGrammar = findViewById(R.id.buttonGrammar);
        buttonVocabulary = findViewById(R.id.buttonVocabulary);
        buttonSpeaking = findViewById(R.id.buttonSpeaking);
        buttonTrick = findViewById(R.id.buttonTrick);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsMenu.this, Information.class);
                startActivity(intent);
                finish();
            }
        });

        buttonGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsMenu.this, LessonsGrammar.class);
                startActivity(intent);
                finish();
            }
        });

        buttonVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsMenu.this, LessonsVocabulary.class);
                startActivity(intent);
                finish();
            }
        });


        buttonSpeaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsMenu.this, LessonsSpeaking.class);
                startActivity(intent);
                finish();
            }
        });


        buttonTrick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonsMenu.this, LessonsTrick.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
