package android.doan.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Level extends AppCompatActivity{
    Button buttonEasy, buttonMedium, buttonHard;
    Database Data;
    ArrayList<Question> easylist, mediumlist, hardlist;
    ImageView nextbtn;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        nextbtn = findViewById(R.id.nextbtn);
        buttonEasy = findViewById(R.id.btnEasy);
        buttonMedium = findViewById(R.id.btnMedium);
        buttonHard = findViewById(R.id.btnHard);


        Data = new Database(this,"Data.sqlite",null,2);
        Data.QueryData("DROP TABLE IF EXISTS Question");
        Data.QueryData("CREATE TABLE IF NOT EXISTS Question(Ma INTEGER PRIMARY KEY, CauHoi VARCHAR, DoKho  INTEGER, AnswerA VARCHAR, AnswerB VARCHAR, AnswerC VARCHAR, AnswerD VARCHAR, Correct VARCHAR);");
        Data.QueryData("INSERT INTO Question VALUES\n" +
                " (1,'Some snakes lay eggs, but _________ give birth to live offspring',1,'other','the other','others','the others','others'), \n" +
                "(2, 'I can remember _________ you about this three times already. ',1,'telling','to tell','told','tell','telling'), \n"+
                "(3, 'Don`t  worry about the party. I`ll _________ to it. ',1,'offer','care','see','devote','see'), \n"+
                "(4, '_____________ have made communication faster and easier through the use of e-mail and the Internet is widely recognize  ',1,'It is that computers','That computers','Computers that','That it is computers','That computers'), \n"+
                "(5, '_________ you should do now is to take a long holiday ',1,'That','Which','What','It','What'), \n"+
                "(6, '____________  you to be offered that job, would you have to move to another city? ',1,'Provided that','Should','Were','Had','Were'), \n"+
                "(7, 'I ___________Katie, an old friend of mine, on the way home from work yesterday.  ',1,'came into','ran into','call off','get into','ran into'), \n"+
                "(8, 'Tom was wearing a suit, ___________ was unsuitable for an informal gathering. ',1,'and','it','which','that','which'), \n"+
                "(9, 'Anne: Make yourself at home \n John:_________________.',1,'Yes, Can I help you?','Not at all. Don`t mention it.','Thanks! Same to you.','That`s very kind. Thank you','That`s very kind. Thank you'), \n"+
                "(10, 'My car would not start ____________ Jenny`s started immediately ',1,'whereas','though','however','nevertheless','whereas'), \n"+
                "(11, 'You work very har I`m sure you`ll have no _______ the exam ',1,'difficulties of passing','difficulty passing','difficulties to pass','difficulty to pass','difficulty passing'), \n"+
                "(12, '_____________________ director must have surprised all the staff ',1,'You nominated','Your being nominated','You have been nominated','Your nominating','Your being nominated'), \n"+
                "(13, 'This is such an important question that we can`t _________________thinking it over. ',1,'point','use','help','stand','help'), \n"+
                "(14, '________________ the Christmas shopping season begins. ',1,'That is after Thanksgiving','After Thanksgiving it is','It is after Thanksgiving that','It is Thanksgiving that','It is after Thanksgiving that'), \n"+
                "(15, 'My new glasses cost me _______ the last pair I bought last month. ',1,'more than three times','three times as much as','more three times than','as much three times as','three times as much as'), \n"+
                "(16, 'You will find their house __________ you take a good street map with you. ',1,'as long as','even if','unless','otherwise','as long as'), \n"+
                "(17, 'By the end of last March, I _____ English for five years. ',1,'was studying','would be studying','has been studying','had been studying','had been studying'), \n"+
                "(18, 'You`d better stop spending money, _______ you will end up in debt ',1,'unless','otherwise','if','in case','otherwise'), \n"+
                "(19, 'The people in my class, _____ are very friendly. ',1,'most of international students','the most international students','almost international students','mostly international students','mostly international students'), \n"+
                "(20, 'He is determined to finish the job _____________ long it takes ',1,'whenever','whatever','no matter','however','however'), \n"+
                "(21, 'She _____ for lost time by studying at weekends.  ',1,'got up','set about','made up','put in','made up'), \n"+
                "(22, 'What is your opinion about Bob`s condition?  - I recommend ___________ as much as possible. ',1,'him rest','that he rests','that he rest','him to rest','that he rest'), \n"+
                "(23, 'Alan and Sue ___________ an argument. They are not speaking to each other. ',1,'must have','must have had','might have','might had','must have had'), \n"+
                "(24, '______________________, we tried our best to complete it. ',1 , 'As though the homework was difficult','Thanks to the difficult homework','Difficult as the homework was','Despite the homework was difficult','Difficult as the homework was'), \n"+
                "(25, 'Only when the ground is kept moist, _________________ germinate.',1,' will grass seeds','grass seeds wil','does grass seeds','grass seeds does','does grass seeds'), \n"+
                "(26, 'She would rather I ________ harder now.  ',1,'study','studying','am studying','studied','studied'), \n"+
                "(27, 'The concert didn`t come ______ our expectations.  ',1,'up to','up against','round','up with','up to'), \n"+
                "(28, 'Excuse me, is anybody sitting here?   -“_________________________”.   ',1,'No, thanks','Yes, I am so glad','Sorry, the seat is taken','You are welcome','Sorry, the seat is taken'), \n"+
                "(29, 'My uncle _______ golf when he retired from work.      ',1,'took on','took up','took over','took after','took up'), \n"+
                "(30, ' By the end of next month, we _______ our English course.  ',1,' have completed','will be completed','will have completed','completed','will have completed'), \n"+
                "(31, 'You should be responsible for_______ you have done.  ',1,'that','why','which','what','what'), \n"+
                "(32, '______________ in the US in 1977, this festival is celebrated with feasts and songs in the home for seven days and nights.  ',1,'Africa introduced','Africa introducing','Introducing from Africa ','Introduced from Africa','Introduced from Africa'), \n"+
                "(33, '______________ she spoke did I realized that she was English. ',1,'No sooner','No longer','Not until','Hardly','Not until'), \n"+
                "(34, ' I`m not opposed to ______ with us, as long as it`s only for a few days.  ',1,'them to stay','them staying','their stay','their staying','their staying'), \n"+
                "(35, 'Henry_______________ a rich man today if he had been more careful in the past.  ',2,'will have been','will be','would have been','would be','would be'), \n"+
                "(36, ' _________ do women do all the housework with their hands.  ',2,'No sooner','Not until','No more','No longer','No longer'), \n"+
                "(37, 'Please forgive me, I don`t ___________ to upset you.      ',2,'think','mind','mean','suppose','mean'), \n"+
                "(38, '   _______ we have finished the course, we should start doing more revision work.',2,'For now','Now that','Ever since','By now ','Now that'), \n"+
                "(39, ' _________ we heard at the conference was encouraging.  ',2,'That','Where','When','What','What'), \n"+
                "(40, ' I`d _________ you didn`t leave just at the moment.  ',2,'rather','like','better','love','rather'), \n"+
                "(41, 'Forget it. It is no use crying over spilt _________.  ',2,'water','juice','milk','lemonade','milk'), \n"+
                "(42, 'Smith knew that he could make a success of the little weekly newspaper in the long _______ ',2,'time','run','distance',' step','run'), \n"+
                "(43, '________ that she could not say anything. ',2,'Upset was she','However upset was she','So upset was she that','So upset she was','So upset was she that'), \n"+
                "(44, 'I ________ my best suit at the party last night - everyone else was very casually dresse ',2,'needn`t wear','mustn`t wear','needn`t have worn','mustn`t have worn','needn`t have worn'), \n"+
                "(45, 'By far, _________________________ of Saudi Arabia is oil. ',2,'it is the most important export','the most important export','the most important export is','that it the most important export','the most important export'), \n"+
                "(46, ' Who did you invite to dinner last night? – No one _______ than Frank and his family. ',2,'another','the other','other','the others','other'), \n"+
                "(47, 'The man who lives opposite us sometimes comes __________ for a cup of coffee.  ',2,'over','off','on','to','over'), \n"+
                "(48, 'I have three brothers, _____________ are businessmen. ',2,'that all of them','who they all','all of whom','who all of them','all of whom'), \n"+
                "(49, 'It was _________________ that we spent the whole day at the beach. ',2,'so nice a weather','such nice weather','such nice a weather','so a  nice weather','such nice weather'), \n"+
                "(50, ' What are you going to buy in this store?   _  Nothing, _________ want is too much expensive',2,'That I','What I','That what I','What do I','What I'), \n"+
                "(51, 'There`s no ______ fixing that toy. He`ll just break it again. ',2,'point','worth','harm','good','point'), \n"+
                "(52, 'It is important that he ____________ with Dr. Baker immediately.  ',2,'will speak','speaks','speak','speaks','speak'), \n"+
                "(53, 'I was just walking along the street when I __________ someone I hadn`t seen for years. ',2,'came across','came over',' came by','came off','came across'), \n"+
                "(54, ' Which of the two boys is granted a scholarship?- _________ of them is. ',2,'All','None','Neither','Both','Neither'), \n"+
                "(55, 'I cannot stay up late at night. I prefer ___________ early.  ',2,'turning on','turning up','turning in','turning out','turning in'), \n"+
                "(56, 'The classroom has not electric fan, ___________ is quite different from that in the advertisement.',2,'what','who','which','that','which'), \n"+
                "(57, 'She is so absent-minder. She _______________ her cell phone three times. ',2,'lost','was losing','has lost','had lost','has lost'), \n"+
                "(58, 'He always did well at school, despite ___________his early education disrupted by illness. ',2,'being','having','putting','sending','having'), \n"+
                "(59, 'Tom has never been to Madrid, but he talks as if he ______ there himself. ',2,'is','was','were','has been','has been'), \n"+
                "(60, '___________________about genetic diseases has increased is welcome news. ',2,'Scientific knowledge','It was scientific knowledge','Though scientific knowledge','That scientific knowledge','That scientific knowledge'), \n"+
                "(61, 'You looked tire _____________________ hard all day?  ',2,'Were you working','Have you been working','Do you work','Are you working','Have you been working'), \n"+
                "(62, '  ______________ that the company has shown rapid growth in the last two ears. ',2,'It is reported','They are reported','The report was','Reporting','It is reported'), \n"+
                "(63, 'Doing a lot of homework may ___________you to pass the exam.  ',2,'make it easier for','make easier for','be easy for','make easy that','make it easier for'), \n"+
                "(64, ' If you need any support, you can _________ me to back you up.   ',2,'believe on','rely on','depend on','put on','rely on'), \n"+
                "(65, ' It is time the government _________measures to reduce the current high unemployment rate. ',2,'takes','take','took','must take','took'), \n"+
                "(66, '_________________ nowadays buys goods on the Internet ',2,'Many people','Almost people','Most people','Many a person','Many a person'), \n"+
                "(67, 'On being told about her sack ____________________. ',2,'Her boss felt sorry for Mary','Mary was shocked','Mary`s face turned pale','Mary`s reaction was normal','Mary was shocked'), \n"+
                "(68, 'They live on a busy street. _______________ a lot of noise and pollution from traffic',3,'It must be','It must have','There must have','There must be','There must be'), \n"+
                "(69, ' It is essential that Alice __________ Tom of the meeting tomorrow. ',3,'remind','reminds','will remind','must remind','remind'), \n"+
                "(70, '  ____________ seemed a miracle to us.',3,'His recover after so soon','That he recovered so soon','His being recovered so soon','When he had recovered so soon','His being recovered so soon'), \n"+
                "(71, ' Remember to ____________ the campfire before you leave.  ',3,'put off','put down','put out','put up','put out'), \n"+
                "(72, '_________ you visit him, give him my best wishes. ',3,'Could','Would','Should','Might','Should'), \n"+
                "(73, '___________ more help, I can call my neighbor. ',3,'Should I need','I have needed','I should need','Needed','Should I need'), \n"+
                "(74, 'The house plants need_________ before noon.',3,'watering','to water','be watered','being watered','watering'), \n"+
                "(75, 'I have never been windsurfing, but I`d love to have________ at it.  ',3,'a trial','a look','a taste',' a go','a trial'), \n"+
                "(76, '______________you have watched, which film impresses you most ?  ',3,'All of films','All of the films','Of films all','Of all the films','Of all the films'), \n"+
                "(77, 'I am _________tired to think about that problem at the moment. ',3,'nearly','simply','much more','far too','far too'), \n"+
                "(78, 'The teacher as well as all the students ______ very excited about going camping next week. ',3,'was','were','is','has been','were'), \n"+
                "(79, '______he does sometimes interests me a lot.',3,'When','Why','What','How','What'), \n"+
                "(80, '______________ of the students in my class could solve the problem yesterday.',3,'Not much','No','None','Neither','None'), \n"+
                "(81, 'People who work as hard as Bill Gates are few and far ________.  ',3,'away','between','from','off','between'), \n"+
                "(82, 'John was praised for his bravery, _______ his colleagues were criticized for their cowardice. ',3,'though','whereas','however','therefore','whereas'), \n"+
                "(83, 'We insist that a meeting________ as soon as possible.  ',3,'be held','is held','were held','will be held','be held'), \n"+
                "(84, ' _____________ I`m concerned , it`s quite all right for you to leave early.   ',3,'As long as','As far as','As well as','As much as','As far as'), \n"+
                "(85, 'They are good friends, but in terms of sports, they are worlds ___________.  ',3,'away','separate','apart','different','apart'), \n"+
                "(86, 'Her husband treated her badly. I`m surprised she ___________________ it for so long. ',3,'put up with','put off','put through','put up ','put up with'), \n"+
                "(87, 'Our school doesn`t break ______ until the end of July. ',3,'out','in','off','up','off'), \n"+
                "(88, ' AIDS is ______________ that scientists are doing research to find a cure. ',3,'a so serious disease','so a serious diseases','so serious a disease','a such serious disease ','so serious a disease'), \n"+
                "(89, '_______________ trying to make him change his min  ',3,'It`s no point','It`s no hope','It`s no useless','It`s no use','It`s no use'), \n"+
                "(90, 'I think you should choose ________ color. This one is too dark. ',3,'other','another','the other','others','another'), \n"+
                "(91, 'Were she ten years younger, she ______________ the beauty contest.  ',3,'will enter','had entered','would enter','would have entered','would enter'), \n"+
                "(92, ' I don`t think he will get ________ the shock in such a short period of time.  ',3,'off','out','over','away','over'), \n"+
                "(93, 'You __________ give me a lift. I can easily catch a bus. ',3,'don`t have','needn`t','don`t need','mustn`t','needn`t'), \n"+
                "(94, 'Martin tried on three jackets, ___________ fitted him. ',3,'none','none of which','none of them','not','none of which'), \n"+
                "(95, 'I have English classes ________ day ; on Mondays, Wednesdays and Fridays.  ',3,'all other','each other','every other','any other','every other'), \n"+
                "(96, ' _______________ caused certain diseases such as malaria was not known until the early 20th century. ',3,'That mosquitoes','Mosquitoes','Since mosquitoes','Mosquitoes which','That mosquitoes'), \n"+
                "(97, ' It`s essential that every student __________ the exam before attending the course ',3,'pass','passes','would pass','passed','pass'), \n"+
                "(98, 'Did your brother go to France ?   - No,  our parents suggested that we_____________ there at night. ',3,'won`t go','don`t go','not go','not to go','not go'), \n"+
                "(99, '_____________________ appear, they are really much larger than the Earth. ',3,'As the small stars','The stars as small','Despite of the small stars','Small as the stars','Small as the stars'), \n"+
                "(100,'I haven`t seen Peter for a long time. I will _________ him this weeken ',3,'call for','call in','call off','call on','call on');");

                buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                easylist = new ArrayList<Question>();
                getListByLevel(1,easylist);
                sendData("Easy",easylist,intent,bundle);
            }
        });


        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                mediumlist = new ArrayList<Question>();
                getListByLevel(2,mediumlist);
                sendData("Medium",mediumlist,intent,bundle);
            }
        });
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                hardlist = new ArrayList<Question>();
                getListByLevel(3,hardlist);
                sendData("Hard",hardlist,intent,bundle);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Menu.class);
                startActivity(intent);
            }

        });

    }

    public void getListByLevel(int level, ArrayList list){
        Cursor data = Data.GetData("SELECT * FROM Question WHERE DoKho =" + level +";");
        while(data.moveToNext()){
            Question question = new Question(data.getInt(0),data.getString(1),data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7));
            list.add(question);
        }
    }

    public void sendData(String level, ArrayList list,Intent intent,Bundle bundle){
        intent.putExtra("level",level);
        bundle.putSerializable("ArrayList",(Serializable)list);
        intent.putExtra("QuestionList",bundle);
        startActivity(intent);
    }
}
