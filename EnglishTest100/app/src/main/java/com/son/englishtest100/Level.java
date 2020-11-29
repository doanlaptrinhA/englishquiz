package com.son.englishtest100;

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
    ImageView buttonEasy, buttonMedium, buttonHard;
    TextView txtone,txttwo,txtthree;
    Database Data;
    ArrayList<Question> easylist, mediumlist, hardlist;
    ImageView nextbtn;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        nextbtn = findViewById(R.id.nextbtn);
        buttonEasy = findViewById(R.id.buttonEasy);
        buttonMedium = findViewById(R.id.buttonMedium);
        buttonHard = findViewById(R.id.buttonHard);

        txtone = findViewById(R.id.txtone);
        txttwo = findViewById(R.id.txttwo);
        txtthree = findViewById(R.id.txtthree);

        Data = new Database(this,"Data.sqlite",null,2);
        Data.QueryData("DROP TABLE IF EXISTS Question");
        Data.QueryData("CREATE TABLE IF NOT EXISTS Question(Ma INTEGER PRIMARY KEY, CauHoi VARCHAR, DoKho  INTEGER, AnswerA VARCHAR, AnswerB VARCHAR, AnswerC VARCHAR, AnswerD VARCHAR, Correct VARCHAR);");
        Data.QueryData("INSERT INTO Question VALUES\n" +
                " (1,'Some snakes lay eggs, but _________ give birth to live offspring',1,'A.other','B.the other','C.others','D.the others','C'), \n" +
                "(2, 'I can remember _________ you about this three times already. ',1,'A.telling  ','B.to tell  ','C.told  ','D.tell','A'), \n"+
                "(3, 'Don`t  worry about the party. I`ll _________ to it. ',1,'A.offer ','B.care ','C.see ','D.devote','C'), \n"+
                "(4, '_____________ have made communication faster and easier through the use of e-mail and the Internet is widely recognize  ',1,'A.It is that computers ','B.That computers ','C.Computers that ','D.That it is computers','B'), \n"+
                "(5, '_________ you should do now is to take a long holiday ',1,'A.That ','B.Which ','C.What ','D.It','C'), \n"+
                "(6, '____________  you to be offered that job, would you have to move to another city? ',1,'A.Provided that ','B.Should ','C.Were ','D.Had','C'), \n"+
                "(7, 'I ___________Katie, an old friend of mine, on the way home from work yesterday.  ',1,'A.came into ','B.ran into ','C.call off ','D.get into','B'), \n"+
                "(8, 'Tom was wearing a suit, ___________ was unsuitable for an informal gathering. ',1,'A.and','B.it','C.which','D.that','C'), \n"+
                "(9, 'Anne: Make yourself at home \n John:_________________.',1,'A.Yes, Can I help you?   ','B.Not at all. Don`t mention it.   ','C.Thanks! Same to you.','D.That`s very kind. Thank you','D'), \n"+
                "(10, 'My car would not start ____________ Jenny`s started immediately ',1,'A.whereas ','B.though ','C.however ','D.nevertheless','A'), \n"+
                "(11, 'You work very har I`m sure you`ll have no _______ the exam ',1,'A.difficulties of passing ','B.difficulty passing','C.difficulties to pass ','D.difficulty to pass','B'), \n"+
                "(12, '_____________________ director must have surprised all the staff ',1,'A.You nominated ','B.Your being nominated ','C.You have been nominated ','D.Your nominating','B'), \n"+
                "(13, 'This is such an important question that we can`t _________________thinking it over. ',1,'A.point ','B.use ','C.help ','D.stand','C'), \n"+
                "(14, '________________ the Christmas shopping season begins. ',1,'A.That is after Thanksgiving ','B.After Thanksgiving it is','C. It is after Thanksgiving that ','D.It is Thanksgiving that','C'), \n"+
                "(15, 'My new glasses cost me _______ the last pair I bought last month. ',1,'A.more than three times   ','B.three times as much as  ','C.more three times than  ','D.as much three times as','B'), \n"+
                "(16, 'You will find their house __________ you take a good street map with you. ',1,'A.as long as ','B.even if ','C.unless ','D.otherwise','A'), \n"+
                "(17, 'By the end of last March, I _____ English for five years. ',1,'A.was studying ','B.would be studying','C.has been studying ','D.had been studying','D'), \n"+
                "(18, 'You`d better stop spending money, _______ you will end up in debt ',1,'A.unless ','B.otherwise ','C.if ','D.in case','B'), \n"+
                "(19, 'The people in my class, _____ are very friendly. ',1,'A.most of international students ','B.the most international students','C.almost international students ','D.mostly international students','D'), \n"+
                "(20, 'He is determined to finish the job _____________ long it takes ',1,'A.whenever','B.whatever','C.no matter','D.however ','D'), \n"+
                "(21, 'She _____ for lost time by studying at weekends.  ',1,'A.got up  ','B.set about','C.made up','D.put in','C'), \n"+
                "(22, 'What is your opinion about Bob`s condition?  - I recommend ___________ as much as possible. ',1,'A.him rest ','B.that he rests ','C.that he rest ','D.him to rest ','C'), \n"+
                "(23, 'Alan and Sue ___________ an argument. They are not speaking to each other. ',1,'A.must have ','B.must have had ','C.might have ','D.might had ','B'), \n"+
                "(24, '______________________, we tried our best to complete it. ',1 , 'A.As though the homework was difficult ','B.Thanks to the difficult homework','C. Difficult as the homework was','D.Despite the homework was difficult','C'), \n"+
                "(25, 'Only when the ground is kept moist, _________________ germinate.',1,'A. will grass seeds','B.grass seeds wil','C.does grass seeds','D.grass seeds does','C'), \n"+
                "(26, 'She would rather I ________ harder now.  ',1,'A.study','B.studying','C.am studying','D.studied ','D'), \n"+
                "(27, 'The concert didn`t come ______ our expectations.  ',1,'A.up to','B.up against','C.round','D.up with','A'), \n"+
                "(28, 'Excuse me, is anybody sitting here?   -“_________________________”.   ',1,'A.No, thanks','B.Yes, I am so glad','C.Sorry, the seat is taken ','D.You are welcome','C'), \n"+
                "(29, 'My uncle _______ golf when he retired from work.      ',1,'A.took on      ','B.took up     ','C.took over     ','D.took after','B'), \n"+
                "(30, ' By the end of next month, we _______ our English course.  ',1,'A. have completed ','B.will be completed','C.will have completed ','D.completed','C'), \n"+
                "(31, 'You should be responsible for_______ you have done.  ',1,'A.that ','B.why ','C.which       ','D.what','D'), \n"+
                "(32, '______________ in the US in 1977, this festival is celebrated with feasts and songs in the home        for seven days and nights.  ',1,'A.Africa introduced ','B.Africa introducing  ','C.Introducing from Africa ','D.Introduced from Africa','D'), \n"+
                "(33, '______________ she spoke did I realized that she was English. ',1,'A.No sooner ','B.No longer ','C.Not until ','D.Hardly','C'), \n"+
                "(34, ' I`m not opposed to ______ with us, as long as it`s only for a few days.  ',1,'A.them to stay  ','B.them staying ','C.their stay   ','D.their staying','D'), \n"+
                "(35, 'Henry_______________ a rich man today if he had been more careful in the past.  ',2,'A.will have been ','B.will be ','C.would have been ','D.would be ','D'), \n"+
                "(36, ' _________ do women do all the housework with their hands.  ',2,'A.No sooner ','B.Not until ','C.No more ','D.No longer','D'), \n"+
                "(37, 'Please forgive me, I don`t ___________ to upset you.      ',2,'A.think      ','B.mind       ','C.mean     ','D.suppose','C'), \n"+
                "(38, '   _______ we have finished the course, we should start doing more revision work .   ',2,'A.For now','B.Now that','C.Ever since','D.By now ','B'), \n"+
                "(39, ' _________ we heard at the conference was encouraging.  ',2,'A.That','B.Where','C.When','D.What','D'), \n"+
                "(40, ' I`d _________ you didn`t leave just at the moment.  ',2,'A.rather','B.like','C.better','D.love','A'), \n"+
                "(41, 'Forget it. It is no use crying over spilt _________.  ',2,'A.water','B.juice','C.milk','D.lemonade','C'), \n"+
                "(42, 'Smith knew that he could make a success of the little weekly newspaper in the long _______ ',2,'A.time ','B.run ','C.distance ','D. step','B'), \n"+
                "(43, '________ that she could not say anything. ',2,'A.Upset was she  ','B.However upset was she     ','C.So upset was she that  ','D.So upset she was  ','C'), \n"+
                "(44, 'I ________ my best suit at the party last night - everyone else was very casually dresse ',2,'A.needn`t wear ','B.mustn`t wear  ','C.needn`t have worn ','D.mustn`t have worn','C'), \n"+
                "(45, 'By far, _________________________ of Saudi Arabia is oil. ',2,'A.it is the most important export','B.the most important export  ','C.the most important export is ','D.that it the most important export','B'), \n"+
                "(46, ' Who did you invite to dinner last night? – No one _______ than Frank and his family. ',2,'A.another ','B.the other ','C.other ','D.the others  ','C'), \n"+
                "(47, 'The man who lives opposite us sometimes comes __________ for a cup of coffee.  ',2,'A.over','B.off','C.on','D.to','A'), \n"+
                "(48, 'I have three brothers, _____________ are businessmen. ',2,'A.that all of them','B.who they all','C.all of whom','D.who all of them','C'), \n"+
                "(49, 'It was _________________ that we spent the whole day at the beach. ',2,'A.so nice a weather','B.such nice weather','C.such nice a weather ','D.so a  nice weather','B'), \n"+
                "(50, ' What are you going to buy in this store?   _  Nothing, _________ want is too much expensive  ',2,'A.That I','B.What I','C.That what I','D.What do I','B'), \n"+
                "(51, 'There`s no ______ fixing that toy. He`ll just break it again. ',2,'A.point  ','B.worth','C.harm','D.good','A'), \n"+
                "(52, 'It is important that he ____________ with Dr. Baker immediately.  ',2,'A.will speak','B.speaks','C.speak','D.speaks','C'), \n"+
                "(53, 'I was just walking along the street when I __________ someone I hadn`t seen for years. ',2,'A.came across ','B.came over ','C. came by ','D.came off','A'), \n"+
                "(54, ' Which of the two boys is granted a scholarship?- _________ of them is. ',2,'A.All ','B.None ','C.Neither ','D.Both','C'), \n"+
                "(55, 'I cannot stay up late at night. I prefer ___________ early.  ',2,'A.turning on ','B.turning up ','C.turning in   ','D.turning out','C'), \n"+
                "(56, 'The classroom has not electric fan, ___________ is quite different from that in the advertisement.',2,'A.what ','B.who ','C.which ','D.that                           ','C'), \n"+
                "(57, 'She is so absent-minder. She _______________ her cell phone three times. ',2,'A.lost ','B.was losing ','C.has lost ','D.had lost','C'), \n"+
                "(58, 'He always did well at school, despite ___________his early education disrupted by illness. ',2,'A.being ','B.having ','C.putting ','D.sending   ','B'), \n"+
                "(59, 'Tom has never been to Madrid, but he talks as if he ______ there himself. ',2,'A.is ','B.was ','C.were ','D.has been','D'), \n"+
                "(60, '___________________about genetic diseases has increased is welcome news. ',2,'A.Scientific knowledge ','B.It was scientific knowledge','C.Though scientific knowledge ','D.That scientific knowledge','D'), \n"+
                "(61, 'You looked tire _____________________ hard all day?  ',2,'A.Were you working ','B.Have you been working ','C.Do you work ','D.Are you working','B'), \n"+
                "(62, '  ______________ that the company has shown rapid growth in the last two ears. ',2,'A.It is reported','B.They are reported','C.The report was','D.Reporting ','A'), \n"+
                "(63, 'Doing a lot of homework may ___________you to pass the exam.  ',2,'A.make it easier for','B.make easier for','C.be easy for ','D.make easy that','A'), \n"+
                "(64, ' If you need any support, you can _________ me to back you up.   ',2,'A.believe on ','B.rely on  ','C.depend on','D.put on','B'), \n"+
                "(65, ' It is time the government _________measures to reduce the current high unemployment rate. ',2,'A.takes ','B.take ','C.took ','D.must take','C'), \n"+
                "(66, '_________________ nowadays buys goods on the Internet ',2,'A.Many people  ','B.Almost people ','C.Most people ','D.Many a person','D'), \n"+
                "(67, 'On being told about her sack ____________________. ',2,'A.her boss felt sorry for Mary   ','B.Mary was shocked   ','C.Mary`s face turned pale   ','D.Mary`s reaction was normal','B'), \n"+
                "(68, 'They live on a busy street. _______________ a lot of noise and pollution from traffic ',3,'A.It must be ','B.It must have ','C.There must have ','D.There must be ','D'), \n"+
                "(69, ' It is essential that Alice __________ Tom of the meeting tomorrow. ',3,'A.remind ','B.reminds ','C.will remind ','D.must remind','A'), \n"+
                "(70, '  ____________ seemed a miracle to us.',3,'A.His recover after so soon  ','B.That he recovered so soon  ','C.His being recovered so soon ','D.When he had recovered so soon  ','C'), \n"+
                "(71, ' Remember to ____________ the campfire before you leave.  ',3,'A.put off','B.put down','C.put out','D.put up ','C'), \n"+
                "(72, '_________ you visit him, give him my best wishes. ',3,'A.Could','B.Would','C.Should','D.Might','C'), \n"+
                "(73, '___________ more help, I can call my neighbor. ',3,'A.Should I need','B.I have needed','C.I should need','D.Needed','A'), \n"+
                "(74, 'The house plants need_________ before noon.',3,'A.watering','B.to water','C.be watered ','D.being watered','A'), \n"+
                "(75, 'I have never been windsurfing, but I`d love to have________ at it.  ',3,'A.a trial','B.a look','C.a taste ','D. a go ','A'), \n"+
                "(76, '______________you have watched, which film impresses you most ?  ',3,'A.All of films','B.All of the films','C.Of films all','D.Of all the films','D'), \n"+
                "(77, 'I am _________tired to think about that problem at the moment. ',3,'A.nearly','B.simply','C.much more','D.far too','D'), \n"+
                "(78, 'The teacher as well as all the students ______ very excited about going camping next week. ',3,'A.was  ','B. were ','C. is ','D.has been','B'), \n"+
                "(79, '______he does sometimes interests me a lot.',3,'A.When  ','B.Why  ','C.What  ','D.How','C'), \n"+
                "(80, '______________ of the students in my class could solve the problem yesterday.',3,'A.Not much ','B.No ','C.None ','D.Neither','C'), \n"+
                "(81, 'People who work as hard as Bill Gates are few and far ________.  ',3,'A.away ','B.between ','C.from ','D.off','B'), \n"+
                "(82, 'John was praised for his bravery, _______ his colleagues were criticized for their cowardice. ',3,'A.though ','B.whereas ','C.however ','D.therefore','B'), \n"+
                "(83, 'We insist that a meeting________ as soon as possible.  ',3,'A.be held ','B.is held ','C.were held ','D.will be held','A'), \n"+
                "(84, ' _____________ I`m concerned , it`s quite all right for you to leave early.   ',3,'A.As long as ','B.As far as  ','C.As well as ','D.As much as','B'), \n"+
                "(85, 'They are good friends, but in terms of sports, they are worlds ___________.  ',3,'A.away ','B.separate ','C.apart ','D.different','C'), \n"+
                "(86, 'Her husband treated her badly. I`m surprised she ___________________ it for so long. ',3,'A.put up with','B.put off','C.put through','D.put up ','A'), \n"+
                "(87, 'Our school doesn`t break ______ until the end of July. ',3,'A.out','B.in','C.off','D.up','C'), \n"+
                "(88, ' AIDS is ______________ that scientists are doing research to find a cure. ',3,'A.a so serious disease','B.so a serious diseases','C.so serious a disease','D.a such serious disease ','C'), \n"+
                "(89, '_______________ trying to make him change his min  ',3,'A.It`s no point','B.It`s no hope','C.It`s no useless','D.It`s no use','D'), \n"+
                "(90, 'I think you should choose ________ color. This one is too dark. ',3,'A.other','B.another','C.the other','D.others','B'), \n"+
                "(91, 'Were she ten years younger, she ______________ the beauty contest.  ',3,'A.will enter','B.had entered  ','C.would enter','D.would have entered    ','C'), \n"+
                "(92, ' I don`t think he will get ________ the shock in such a short period of time.  ',3,'A.off','B.out','C.over','D.away','C'), \n"+
                "(93, 'You __________ give me a lift. I can easily catch a bus. ',3,'A.don`t have ','B.needn`t ','C.don`t need ','D.mustn`t','B'), \n"+
                "(94, 'Martin tried on three jackets, ___________ fitted him. ',3,'A.none ','B.none of which ','C.none of them ','D.not','B'), \n"+
                "(95, 'I have English classes ________ day ; on Mondays, Wednesdays and Fridays.  ',3,'A.all other ','B.each other ','C.every other ','D.any other','C'), \n"+
                "(96, ' _______________ caused certain diseases such as malaria was not known until the early 20th century. ',3,'A.That mosquitoes ','B.Mosquitoes ','C.Since mosquitoes ','D.Mosquitoes which','A'), \n"+
                "(97, ' It`s essential that every student __________ the exam before attending the course ',3,'A.pass ','B.passes ','C.would pass ','D.passed','A'), \n"+
                "(98, 'Did your brother go to France ?   - No,  our parents suggested that we_____________ there at night. ',3,'A.won`t go ','B.don`t go  ','C.not go ','D.not to go  ','C'), \n"+
                "(99, '_____________________ appear, they are really much larger than the Earth. ',3,'A.As the small stars ','B.The stars as small ','C.Despite of the small stars   ','D.Small as the stars  ','D'), \n"+
                "(100,'I haven`t seen Peter for a long time. I will _________ him this weeken ',3,'A.call for','B.call in','C.call off ','D.call on','D');");

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
        txtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                easylist = new ArrayList<Question>();
                getListByLevel(1,easylist);
                sendData("Easy",easylist,intent,bundle);
            }
        });
        txttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                mediumlist = new ArrayList<Question>();
                getListByLevel(2,mediumlist);
                sendData("Medium",mediumlist,intent,bundle);
            }
        });
        txtthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this,Random.class);
                Bundle bundle = new Bundle();
                hardlist = new ArrayList<Question>();
                getListByLevel(3,hardlist);
                sendData("Hard",hardlist,intent,bundle);
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
