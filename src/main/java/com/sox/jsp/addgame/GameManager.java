package com.sox.jsp.addgame;

import com.sox.jsp.addgame.DTO.QuestionDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class GameManager {
    static GameManager gameManager;

    QuestionMaker questionMaker;

    int GAMESET = 10;

    private GameManager() {
        questionMaker = QuestionMaker.getInstance();
    }

    public static GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }

        return gameManager;
    }

    public void startGame() {
        for (int i = 0; i < GAMESET; i++) {
            questionMaker.makeQuestion();
        }
    }

    public String makeCode(String user) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar time = Calendar.getInstance();
        Random rd = new Random();

        String str = user + format.format(time.getTime()) + rd.nextInt(10000);

        return str;
    }
}
