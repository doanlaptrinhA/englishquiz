package android.doan.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class LessonsTrick extends AppCompatActivity {
    MediaPlayer mp;
    int length;
    Button btnTrickOne, btnTrickTwo;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_lessons_trick);

        next = findViewById(R.id.next);
        btnTrickOne = findViewById(R.id.btnTrickOne);
        btnTrickTwo = findViewById(R.id.btnTrickTwo);

        mp = MediaPlayer.create(LessonsTrick.this, R.raw.lessonsmusic);
        mp.start();
        mp.setLooping(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(LessonsTrick.this, LessonsMenu.class);
                startActivity(intent);
                finish();
            }
        });

        btnTrickOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsTrick.this);
                builder.setTitle("Part One");
                builder.setMessage(Html.fromHtml("<b>Trick Part One:</b> <br>" +
                        "- Set yourself small goals<br>" +
                        "- Create a study schedule<br>" +
                        "- Practice a little bit every day<br>" +
                        "- Discover what type of learner you are: Auditory, visual or tactile<br>" +
                        "- Watch movies with English dialogue<br>" +
                        "- Learn new vocabulary with flashcards<br>" +
                        "- Track your progress.<br>" +
                        "<br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnTrickTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsTrick.this);
                builder.setTitle("Part Two");
                builder.setMessage(Html.fromHtml("<b>Trick Part Two:</b> <br>" +
                        "- Accept That English Is a Weird Language<br>" +
                        "- Get More out of Listening<br>" +
                        "- Remember the Answer Is in the QuestionDatabase<br>" +
                        "- Learn and Study Phrases<br>" +
                        "- Don’t Study Grammar Too Much<br>" +
                        "- Learn Intonation, Body Language, and Gestures<br>" +
                        "- Don’t Be Afraid to Make Mistakes<br>" +
                        "- Learn from Everyone<br>" +
                        "- Use Speech-to-text for all (English) Text Messaging<br>" +
                        "- Record Your Own English-language Audiobooks<br>" +
                        "- Record Yourself Reading Material That You Want to Learn, Then Listen to It Throughout Your Day<br>" +
                        "<br>"
                ));
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.dismiss();
                    }
                });
                final Dialog dialog = builder.create();
                dialog.show();
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
