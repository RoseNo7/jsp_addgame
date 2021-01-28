package com.sox.jsp.addgame.DAO;

import com.sox.jsp.addgame.DBManager;
import com.sox.jsp.addgame.DTO.QuestionDTO;
import com.sox.jsp.addgame.QuestionMaker;

import java.util.ArrayList;

public class QuestionDAO {
    static QuestionDAO questionDAO;

    private QuestionDAO() {}

    public static QuestionDAO getInstance() {
        if (questionDAO == null) {
            questionDAO = new QuestionDAO();
        }

        return questionDAO;
    }

    public ArrayList<QuestionDTO> selectQuestion(String code) {
        DBManager dbManager = DBManager.getInstance();
        ArrayList<QuestionDTO> questionDTOS = new ArrayList<>();

        String sql = "SELECT no, question, answer FROM question WHERE game_code = ?";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, code);

            dbManager.setRs(dbManager.getPstate().executeQuery());

            while (dbManager.getRs().next()) {
                QuestionDTO questionDTO = new QuestionDTO();

                questionDTO.setQuestion(dbManager.getRs().getString("question"));
                questionDTO.setAnswer(dbManager.getRs().getInt("answer"));

                questionDTOS.add(questionDTO);
            }

        } catch (Exception e) {

        }

        return questionDTOS;
    }

    public void insertQuestion(String code) {
        DBManager dbManager = DBManager.getInstance();
        QuestionMaker questionMaker = QuestionMaker.getInstance();

        String sql = "INSERT INTO question(game_code, no, question, answer) VALUES(?, ?, ?, ?)";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));

            for (int i = 0; i < questionMaker.getQuestions().size(); i++) {
                dbManager.getPstate().setString(1, code);
                dbManager.getPstate().setInt(2, i+1);
                dbManager.getPstate().setString(3, questionMaker.getQuestions().get(i).getQuestion());
                dbManager.getPstate().setInt(4, questionMaker.getQuestions().get(i).getAnswer());

                dbManager.getPstate().executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
