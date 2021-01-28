package com.sox.jsp.addgame;

import com.sox.jsp.addgame.DTO.AnswerDTO;
import com.sox.jsp.addgame.DTO.QuestionDTO;

import java.util.ArrayList;

public class AssessmentManager {
    static AssessmentManager assessmentManager;
    int score = 0;

    private AssessmentManager() {}

    public static AssessmentManager getInstance() {
        if (assessmentManager == null) {
            assessmentManager = new AssessmentManager();
        }

        return assessmentManager;
    }

    public int assess(ArrayList<QuestionDTO> questionDTOS, String[] inputAnswer) {
        for (int i = 0; i < questionDTOS.size(); i++) {
            if (questionDTOS.get(i).getAnswer() == Integer.parseInt(inputAnswer[i])) {
                score++;
            }
        }

        return score;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}