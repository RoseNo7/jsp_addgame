package com.sox.jsp.addgame.DAO;

import com.sox.jsp.addgame.DBManager;
import com.sox.jsp.addgame.DTO.GameDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GameDAO {
    static GameDAO gameDAO;

    private GameDAO() {}

    public static GameDAO getInstance() {
        if(gameDAO == null) {
            gameDAO = new GameDAO();
        }

        return gameDAO;
    }

    public ArrayList<GameDTO> selectGame(String user){
        DBManager dbManager = DBManager.getInstance();

        ArrayList<GameDTO> games = new ArrayList<>();

        String sql = "SELECT game_code, date FROM game WHERE user_id = ?";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, user);

            dbManager.setRs(dbManager.getPstate().executeQuery());

            while (dbManager.getRs().next()) {
                GameDTO gameDTO = new GameDTO();

                gameDTO.setGameCode(dbManager.getRs().getString("game_code"));
                gameDTO.setDate(dbManager.getRs().getString("date"));

                games.add(gameDTO);
            }
        } catch (Exception e) {

        }

        return games;
    }

    public void insertGame(String user, String code) {
        DBManager dbManager = DBManager.getInstance();

        String sql = "insert into game(user_id, date, game_code) values(?, ?, ?)";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar time = Calendar.getInstance();

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, user);
            dbManager.getPstate().setString(2, format.format(time.getTime()));
            dbManager.getPstate().setString(3, code);

            dbManager.getPstate().executeUpdate();

        } catch (Exception e) {

        }
    }
}
