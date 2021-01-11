package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingLevel extends AppCompatActivity {
    Button buttonEasy, buttonMedium, buttonHard;
    DatabaseHelper Data;
    ArrayList<QuestionDatabase> easylist, mediumlist, hardlist;
    ImageView nextbtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_chooselevel);

        nextbtn = findViewById(R.id.nextbtn);
        buttonEasy = findViewById(R.id.btnEasy);
        buttonMedium = findViewById(R.id.btnMedium);
        buttonHard = findViewById(R.id.btnHard);

        Data = new DatabaseHelper(this, "Data.sqlite", null, 2);
        Data.QueryData("DROP TABLE IF EXISTS QuestionDatabase");
        Data.QueryData("CREATE TABLE IF NOT EXISTS QuestionDatabase(Ma INTEGER PRIMARY KEY, CauHoi VARCHAR, DoKho  INTEGER, AnswerA VARCHAR, AnswerB VARCHAR, AnswerC VARCHAR, AnswerD VARCHAR, Correct VARCHAR);");
        Data.QueryData("INSERT INTO QuestionDatabase VALUES\n" +
                "(1,'She`s a police officer, so she has to wear a ________ at work',1,'police suit','uniform','clothes','dress','uniform'), \n" +
                "(2, 'At the weekend I ________ with some friends',1,'went out','enjoyed','played','went for fun','went out'), \n" +
                "(3, 'He`s so ________! I`m not ________ in anything he says',1,'bored-interested','bored-interesting','boring-interesting','boring-interested','boring-interested'), \n" +
                "(4, 'Happy is the ________ of sad',1,'opposed','oppositive','opposite','oppose','opposite'), \n" +
                "(5, 'He studies maths at university. He`s a ________',1,'professor','student','pupil','studier','student'), \n" +
                "(6, 'Are you planning to go ________ for the weekend?',1,'away','far','out','off','away'), \n" +
                "(7, 'I ___________Katie, an old friend of mine, on the way home from work yesterday.',1,'came into','ran into','call off','get into','ran into'), \n" +
                "(8, 'Do you live in a house or a(n) ________?',1,'home','village','apartment','building','apartment'), \n" +
                "(9, 'Anne: Make yourself at home \n John:_________________.',1,'Yes, Can I help you?','Not at all. Don`t mention it.','Thanks! Same to you.','That`s very kind. Thank you','That`s very kind. Thank you'), \n" +
                "(10, 'Excuse me, I think you`ve ________ a mistake in our bill',1,'given','done','made','had','made'), \n" +
                "(11, 'You work very hard I`m sure you`ll have no _______ the exam.',1,'difficulties of passing','difficulty passing','difficulties to pass','difficulty to pass','difficulty passing'), \n" +
                "(12, 'It`s a good idea, but it`s ________ that the boss will agree with you.',1,'likely','unprobably','unlikely','improbably','unlikely'), \n" +
                "(13, 'This is such an important question that we can`t _________________thinking it over. ',1,'point','use','help','stand','help'), \n" +
                "(14, 'You can`t smoke here - please ________ your cigarette',1,'put out','put down','put away','put up with','put out'), \n" +
                "(15, '`Fruit and vegetables are healthy` \n = Fruit and vegetables are ________',1,'good for you','healthsome','benefit for you','good for health','good for you'), \n" +
                "(16, 'Do you want a ________ or a return ticket?',1,'outbound','single','lonely','one-journey','single'), \n" +
                "(17, 'What time do you go to ________ every day?',1,'job','office','workplace','work','work'), \n" +
                "(18, 'I don`t like my job very much. I`m going to ________ and look for another one',1,'resign','fire','finish','retire','resign'), \n" +
                "(19, 'What time is it? It`s 6.15 - a ________ past six',1,'quarter','fifteen','half','fourth','quarter'), \n" +
                "(20, 'He is determined to finish the job _____________ long it takes ',1,'whenever','whatever','no matter','however','however'), \n" +
                "(21, 'She _____ for lost time by studying at weekends.',1,'got up','set about','made up','put in','made up'), \n" +
                "(22, 'I don`t ________ going out tonight',1,'like','feel like','want to','have mood to','feel like'), \n" +
                "(23, 'Your father`s brother`s daughter is your ________',1,'sister','cousin','cousina','niece','cousin'), \n" +
                "(24, 'They never argue and they enjoy spending time together = They ________',1 , 'get on very well','like themselves very much','relationship very good','relate very well','get on very well'), \n" +
                "(25, 'I`m a bit lost. Can you tell me how to ________ to the university?',1,'find','get','go','reach','get'), \n" +
                "(26, 'She would rather I ________ harder now.',1,'study','studying','am studying','studied','studied'), \n" +
                "(27, 'She doesn`t have brothers or sisters - she`s a(n) ________',1,'only child','lonely child','single child','alone child','only child'), \n" +
                "(28, 'Excuse me, is anybody sitting here?   -“_________________________”.',1,'No, thanks','Yes, I am so glad','Sorry, the seat is taken','You are welcome','Sorry, the seat is taken'), \n" +
                "(29, 'My uncle _______ golf when he retired from work.',1,'took on','took up','took over','took after','took up'), \n" +
                "(30, 'The weather was great - it was really ________',1,'strong sun','sunshine','sunny','sun','sunny'), \n" +
                "(31, 'You should be responsible for_______ you have done.',1,'that','why','which','what','what'), \n" +
                "(32, 'I ________ swimming every Saturday morning',1,'do','go','make','play','go'), \n" +
                "(33, 'I love all fruit, but ________ strawberries',1,'specially','mostly','specifically','especially','especially'), \n" +
                "(34, 'What size do you need: small, medium or ________?',1,'big','huge','giant','large','large'), \n" +
                "(35, 'Our teacher doesn`t ________ us use mobile phones in class',1,'allow','make','forbid','let','let'), \n" +
                "(36, 'Argh! This noise is giving me a ________',1,'headpain','headhurt','headtouch','headache','headache'), \n" +
                "(37, 'Please forgive me, I don`t ___________ to upset you.',2,'think','mind','mean','suppose','mean'), \n" +
                "(38, '_______ we have finished the course, we should start doing more revision work.',2,'For now','Now that','Ever since','By now ','Now that'), \n" +
                "(39, '_________ we heard at the conference was encouraging.',2,'That','Where','When','What','What'), \n" +
                "(40, 'I`d _________ you didn`t leave just at the moment.',2,'rather','like','better','love','rather'), \n" +
                "(41, 'Forget it. It is no use crying over spilt _________.',2,'water','juice','milk','lemonade','milk'), \n" +
                "(42, 'Smith knew that he could make a success of the little weekly newspaper in the long _______ ',2,'time','run','distance',' step','run'), \n" +
                "(43, 'Winters there ________ be really cold sometimes',2,'might','can','may','could','can'), \n" +
                "(44, 'I ________ my best suit at the party last night - everyone else was very casually dresses',2,'needn`t wear','mustn`t wear','needn`t have worn','mustn`t have worn','needn`t have worn'), \n" +
                "(45, 'By far, _________________________ of Saudi Arabia is oil. ',2,'it is the most important export','the most important export','the most important export is','that it the most important export','the most important export'), \n" +
                "(46, 'Who did you invite to dinner last night? – No one _______ than Frank and his family. ',2,'another','the other','other','the others','other'), \n" +
                "(47, 'The man who lives opposite us sometimes comes __________ for a cup of coffee.',2,'over','off','on','to','over'), \n" +
                "(48, 'I have three brothers, _____________ are businessmen. ',2,'that all of them','who they all','all of whom','who all of them','all of whom'), \n" +
                "(49, 'It was _________________ that we spent the whole day at the beach. ',2,'so nice a weather','such nice weather','such nice a weather','so a  nice weather','such nice weather'), \n" +
                "(50, 'What are you going to buy in this store?   _  Nothing, _________ want is too much expensive',2,'That I','What I','That what I','What do I','What I'), \n" +
                "(51, 'There`s no ______ fixing that toy. He`ll just break it again. ',2,'point','worth','harm','good','point'), \n" +
                "(52, 'It is important that he ____________ with Dr. Baker immediately.  ',2,'will speak','speaks','speak','speaks','speak'), \n" +
                "(53, 'I was just walking along the street when I __________ someone I hadn`t seen for years. ',2,'came across','came over',' came by','came off','came across'), \n" +
                "(54, ' Which of the two boys is granted a scholarship?- _________ of them is. ',2,'All','None','Neither','Both','Neither'), \n" +
                "(55, 'I cannot stay up late at night. I prefer ___________ early.  ',2,'turning on','turning up','turning in','turning out','turning in'), \n" +
                "(56, 'The classroom has not electric fan, ___________ is quite different from that in the advertisement.',2,'what','who','which','that','which'), \n" +
                "(57, 'She is so absent-minder. She _______________ her cell phone three times. ',2,'lost','was losing','has lost','had lost','has lost'), \n" +
                "(58, 'He always did well at school, despite ___________his early education disrupted by illness. ',2,'being','having','putting','sending','having'), \n" +
                "(59, 'Tom has never been to Madrid, but he talks as if he ______ there himself. ',2,'is','was','were','has been','has been'), \n" +
                "(60, '___________________about genetic diseases has increased is welcome news. ',2,'Scientific knowledge','It was scientific knowledge','Though scientific knowledge','That scientific knowledge','That scientific knowledge'), \n" +
                "(61, 'You looked tire _____________________ hard all day?  ',2,'Were you working','Have you been working','Do you work','Are you working','Have you been working'), \n" +
                "(62, '  ______________ that the company has shown rapid growth in the last two ears. ',2,'It is reported','They are reported','The report was','Reporting','It is reported'), \n" +
                "(63, 'Doing a lot of homework may ___________you to pass the exam.  ',2,'make it easier for','make easier for','be easy for','make easy that','make it easier for'), \n" +
                "(64, ' If you need any support, you can _________ me to back you up.   ',2,'believe on','rely on','depend on','put on','rely on'), \n" +
                "(65, ' It is time the government _________measures to reduce the current high unemployment rate. ',2,'takes','take','took','must take','took'), \n" +
                "(66, '_________________ nowadays buys goods on the Internet ',2,'Many people','Almost people','Most people','Many a person','Many a person'), \n" +
                "(67, 'On being told about her sack ____________________. ',2,'Her boss felt sorry for Mary','Mary was shocked','Mary`s face turned pale','Mary`s reaction was normal','Mary was shocked'), \n" +
                "(68, 'They live on a busy street. _______________ a lot of noise and pollution from traffic',3,'It must be','It must have','There must have','There must be','There must be'), \n" +
                "(69, ' It is essential that Alice __________ Tom of the meeting tomorrow. ',3,'remind','reminds','will remind','must remind','remind'), \n" +
                "(70, '  ____________ seemed a miracle to us.',3,'His recover after so soon','That he recovered so soon','His being recovered so soon','When he had recovered so soon','His being recovered so soon'), \n" +
                "(71, ' Remember to ____________ the campfire before you leave.  ',3,'put off','put down','put out','put up','put out'), \n" +
                "(72, '_________ you visit him, give him my best wishes. ',3,'Could','Would','Should','Might','Should'), \n" +
                "(73, '___________ more help, I can call my neighbor. ',3,'Should I need','I have needed','I should need','Needed','Should I need'), \n" +
                "(74, 'The house plants need_________ before noon.',3,'watering','to water','be watered','being watered','watering'), \n" +
                "(75, 'I have never been windsurfing, but I`d love to have________ at it.  ',3,'a trial','a look','a taste',' a go','a trial'), \n" +
                "(76, '______________you have watched, which film impresses you most ?  ',3,'All of films','All of the films','Of films all','Of all the films','Of all the films'), \n" +
                "(77, 'I am _________tired to think about that problem at the moment. ',3,'nearly','simply','much more','far too','far too'), \n" +
                "(78, 'The teacher as well as all the students ______ very excited about going camping next week. ',3,'was','were','is','has been','were'), \n" +
                "(79, '______he does sometimes interests me a lot.',3,'When','Why','What','How','What'), \n" +
                "(80, '______________ of the students in my class could solve the problem yesterday.',3,'Not much','No','None','Neither','None'), \n" +
                "(81, 'People who work as hard as Bill Gates are few and far ________.  ',3,'away','between','from','off','between'), \n" +
                "(82, 'John was praised for his bravery, _______ his colleagues were criticized for their cowardice. ',3,'though','whereas','however','therefore','whereas'), \n" +
                "(83, 'We insist that a meeting________ as soon as possible.  ',3,'be held','is held','were held','will be held','be held'), \n" +
                "(84, '_____________ I`m concerned , it`s quite all right for you to leave early.   ',3,'As long as','As far as','As well as','As much as','As far as'), \n" +
                "(85, 'They are good friends, but in terms of sports, they are worlds ___________.  ',3,'away','separate','apart','different','apart'), \n" +
                "(86, 'Her husband treated her badly. I`m surprised she ___________________ it for so long. ',3,'put up with','put off','put through','put up ','put up with'), \n" +
                "(87, 'Our school doesn`t break ______ until the end of July. ',3,'out','in','off','up','off'), \n" +
                "(88, 'AIDS is ______________ that scientists are doing research to find a cure. ',3,'a so serious disease','so a serious diseases','so serious a disease','a such serious disease ','so serious a disease'), \n" +
                "(89, '_______________ trying to make him change his min  ',3,'It`s no point','It`s no hope','It`s no useless','It`s no use','It`s no use'), \n" +
                "(90, 'I think you should choose ________ color. This one is too dark. ',3,'other','another','the other','others','another'), \n" +
                "(91, 'Were she ten years younger, she ______________ the beauty contest.  ',3,'will enter','had entered','would enter','would have entered','would enter'), \n" +
                "(92, ' I don`t think he will get ________ the shock in such a short period of time.  ',3,'off','out','over','away','over'), \n" +
                "(93, 'You __________ give me a lift. I can easily catch a bus. ',3,'don`t have','needn`t','don`t need','mustn`t','needn`t'), \n" +
                "(94, 'Martin tried on three jackets, ___________ fitted him. ',3,'none','none of which','none of them','not','none of which'), \n" +
                "(95, 'I have English classes ________ day ; on Mondays, Wednesdays and Fridays.',3,'all other','each other','every other','any other','every other'), \n" +
                "(96, ' _______________ caused certain diseases such as malaria was not known until the early 20th century.',3,'That mosquitoes','Mosquitoes','Since mosquitoes','Mosquitoes which','That mosquitoes'), \n" +
                "(97, 'It`s essential that every student __________ the exam before attending the course ',3,'pass','passes','would pass','passed','pass'), \n" +
                "(98, 'Did your brother go to France ?   - No,  our parents suggested that we_____________ there at night. ',3,'won`t go','don`t go','not go','not to go','not go'), \n" +
                "(99, '_____________________ appear, they are really much larger than the Earth. ',3,'As the small stars','The stars as small','Despite of the small stars','Small as the stars','Small as the stars'), \n" +
                "(100,'I haven`t seen Peter for a long time. I will _________ him this weeken ',3,'call for','call in','call off','call on','call on');");

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingLevel.this, LoadingQuestions.class);
                Bundle bundle = new Bundle();
                easylist = new ArrayList<QuestionDatabase>();
                getListByLevel(1, easylist);
                sendData("Easy", easylist, intent, bundle);
            }
        });

        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingLevel.this, LoadingQuestions.class);
                Bundle bundle = new Bundle();
                mediumlist = new ArrayList<QuestionDatabase>();
                getListByLevel(2, mediumlist);
                sendData("Medium", mediumlist, intent, bundle);
            }
        });
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingLevel.this, LoadingQuestions.class);
                Bundle bundle = new Bundle();
                hardlist = new ArrayList<QuestionDatabase>();
                getListByLevel(3, hardlist);
                sendData("Hard", hardlist, intent, bundle);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadingLevel.this, QuizDashboard.class);
                startActivity(intent);
            }

        });

    }

    public void getListByLevel(int level, ArrayList list) {
        Cursor data = Data.GetData("SELECT * FROM QuestionDatabase WHERE DoKho =" + level + ";");
        while (data.moveToNext()) {
            QuestionDatabase questionDatabase = new QuestionDatabase(data.getInt(0), data.getString(1), data.getInt(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7));
            list.add(questionDatabase);
        }
    }

    public void sendData(String level, ArrayList list, Intent intent, Bundle bundle) {
        intent.putExtra("level", level);
        bundle.putSerializable("ArrayList", (Serializable) list);
        intent.putExtra("QuestionList", bundle);
        startActivity(intent);
    }
}
