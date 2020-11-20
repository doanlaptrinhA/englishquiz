package com.son.englishtest100;

import java.io.Serializable;

public class Question implements Serializable {
    public int Ma;
    public String CauHoi;
    public int DoKho;
    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String Answer;

    public Question() {
    }

    public Question(int ma, String cauHoi, int doKho, String answerA, String answerB, String answerC, String answerD, String answer) {
        Ma = ma;
        CauHoi = cauHoi;
        DoKho = doKho;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        Answer = answer;
    }

    public int getMa() {
        return Ma;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public int getDoKho() {
        return DoKho;
    }

    public void setMa(int ma) {
        this.Ma = ma;
    }

    public void setCauHoi(String cauHoi) {
        this.CauHoi = cauHoi;
    }

    public void setDoKho(int doKho) {
        this.DoKho = doKho;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
