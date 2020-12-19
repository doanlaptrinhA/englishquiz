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

public class LessonsSpeaking extends AppCompatActivity {
    MediaPlayer mp;
    int length;
    Button btnDaily, btnJob;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_lessons_speaking);

        next = findViewById(R.id.next);
        btnDaily = findViewById(R.id.btnDaily);
        btnJob = findViewById(R.id.btnJob);

        mp = MediaPlayer.create(LessonsSpeaking.this, R.raw.lessonsmusic);
        mp.start();
        mp.setLooping(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.reset();
                mp.stop();
                Intent intent = new Intent(LessonsSpeaking.this, LessonsMenu.class);
                startActivity(intent);
                finish();
            }
        });

        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsSpeaking.this);
                builder.setTitle("Daily Conversation");
                builder.setMessage(Html.fromHtml("<b>Informal greetings:</b> <br>" +
                        "<b>Hello!</b>-A universal greeting that works for every conversation.<br>" +
                        "<b>Hi!</b>-A neutral and friendly greeting.<br>" +
                        "<b>Hey!</b>-An informal and relaxed greeting<br>" +
                        "<b>Greetings!</b>-This is quite formal and rare these days, but could be used humorously among friends.<br>" +
                        "<br>" +
                        "<b>Formal greetings:</b> <br>" +
                        "<b>Good morning!</b>-Reserved for any time before noon.<br>" +
                        "<b>Good afternoon!</b>-Typically used between noon and 5-6 p.m<br>" +
                        "<b>Good evening!</b>-Any time after 6 p.m.<br>" +
                        "<br>" +
                        "<b>Small Talk:</b> <br>" +
                        "How are you? / How are you doing?<br>" +
                        "How is your day going?<br>" +
                        "When did you arrive at the office?<br>" +
                        "What do you think about that email I sent?<br>" +
                        "I have to get going. / It’s time for me to go.<br>" +
                        "I have to run—can we continue later?<br>" +
                        "I think I have everything I need, thank you!<br>" +
                        "Thank you so much for your help!<br>" +
                        "Great seeing you / Great talking to you!<br>" +
                        "Bye! Have a good day!<br>" +
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
        btnJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LessonsSpeaking.this);
                builder.setTitle("Job Interview");
                builder.setMessage(Html.fromHtml("<b>Tell me about yourself?</b><br>" +
                        "I was born and raised in …<br>" +
                        "I attended the University of …<br>" +
                        "I’ve just graduated from the University of …<br>" +
                        "I’ve worked for seven years as a …<br>" +
                        "I’ve worked for various companies including …<br>" +
                        "I enjoy playing …<br>" +
                        "<br>" +
                        "<b>Why are you interested in this job?</b><br>" +
                        "I want to take on more responsibility<br>" +
                        "In line with my qualifications …<br>" +
                        "I’m convinced that ‘company name’ is becoming one of the market leaders<br>" +
                        "I’m impressed by the quality of your products<br>" +
                        "<br>" +
                        "<b>Why should we hire you?</b><br>" +
                        "You should hire me because I’m confident and ….<br>" +
                        "I’m a perfect fit for this job because …<br>" +
                        "I should be hired because I’m …<br>" +
                        "I think I’m a great match for this position.<br>" +
                        "<br>" +
                        "<b>Explain your strengths?</b><br>" +
                        "I’ve always been a team player<br>" +
                        "I believe my strongest trait is my attention to details<br>" +
                        "I pay close attention to my customers’ needs<br>" +
                        "I’m an excellent communicator<br>" +
                        "<br>" +
                        "<b>What experience have you had?</b><br>" +
                        "I’ve worked in retail for six years and was promoted to manager in my second year<br>" +
                        "I have four years of experience as a …<br>" +
                        "I studied at the University of XX (if you haven’t had any work experience yet you can talk about your studies)s<br>" +
                        "I worked for XX as a …<br>" +
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
