package com.sox.jsp.addgame.DAO;

import com.sox.jsp.addgame.DBManager;
import com.sox.jsp.addgame.DTO.AnswerDTO;
import org.json.JSONObject;

public class AnswerDAO {
    static AnswerDAO answerDAO;

    private AnswerDAO() {}

    public static AnswerDAO getInstance() {
        if (answerDAO == null) {
            answerDAO = new AnswerDAO();
        }

        return answerDAO;
    }

    public AnswerDTO selectAnswer(String code) {
        DBManager dbManager = DBManager.getInstance();
        AnswerDTO answerDTO = new AnswerDTO();

        String sql = "SELECT input_ans, score FROM answer WHERE game_code = ?";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, code);

            dbManager.setRs(dbManager.getPstate().executeQuery());

            if (dbManager.getRs().next()) {
                answerDTO.setInputAnswer(dbManager.getRs().getString("input_ans"));
                answerDTO.setScore(dbManager.getRs().getInt("score"));
            }
        } catch (Exception e) {

        }

        return answerDTO;
    }


    public void insertAnswer(AnswerDTO answerDTO) {
        DBManager dbManager = DBManager.getInstance();

        String sql= "INSERT INTO answer(game_code, input_ans, score) VALUES (?, ?, ?)";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, answerDTO.getGameCode());
            dbManager.getPstate().setString(2, answerDTO.getInputAnswer());
            dbManager.getPstate().setInt(3, answerDTO.getScore());

            dbManager.getPstate().executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
