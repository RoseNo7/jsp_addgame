package com.sox.jsp.addgame;

import com.sox.jsp.addgame.DTO.QuestionDTO;

import java.util.ArrayList;
import java.util.Random;

public class QuestionMaker {
    static QuestionMaker questionMaker;
    static ArrayList<QuestionDTO> questions = new ArrayList<>();

    private QuestionMaker() {}

    public static QuestionMaker getInstance() {
        if (questionMaker == null) {
            questionMaker = new QuestionMaker();
        }

        return questionMaker;
    }
    public void makeQuestion() {
        Random rd = new Random();

        int x = rd.nextInt(100);
        int y = rd.nextInt(100);

        String str = x + " + " + y;

        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setQuestion(str);
        questionDTO.setAnswer(x + y);

        QuestionMaker.setQuestions(questionDTO);
    }

    public static void setQuestions(QuestionDTO questionDTO) {
        QuestionMaker.questions.add(questionDTO);
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }
}
