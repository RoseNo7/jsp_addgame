package com.sox.jsp.addgame.DAO;

import com.sox.jsp.addgame.DBManager;
import com.sox.jsp.addgame.DTO.UserDTO;

public class UserDAO {
    static UserDAO userDAO;

    private UserDAO() {}

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }

        return userDAO;
    }

    public UserDTO selectUser(String inputID) {
        DBManager dbManager = DBManager.getInstance();

        UserDTO userDTO = new UserDTO();

        String sql = "select user_id, user_pw from user where user_id = ?";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, inputID);

            dbManager.setRs(dbManager.getPstate().executeQuery());

            if (dbManager.getRs().next()) {
                userDTO.setId(dbManager.getRs().getString("user_id"));
                userDTO.setPassword(dbManager.getRs().getString("user_pw"));
            }
        } catch (Exception e) {

        }

        return userDTO;
    }


    public void insertUser(UserDTO userDTO) {
        DBManager dbManager = DBManager.getInstance();

        String sql = "insert into user(user_id, user_pw, user_name, user_email) values(?, ?, ?, ?)";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));

            dbManager.getPstate().setString(1, userDTO.getId());
            dbManager.getPstate().setString(2, userDTO.getPassword());
            dbManager.getPstate().setString(3, userDTO.getName());
            dbManager.getPstate().setString(4, userDTO.getEmail());
            dbManager.getPstate().executeUpdate();
        } catch (Exception e) {
        }
    }

    public UserDTO selectName(String inputID) {
        DBManager dbManager = DBManager.getInstance();

        UserDTO userDTO = new UserDTO();

        String sql = "select user_id, user_name from user where user_id = ?";

        try {
            dbManager.connect();

            dbManager.setPstate(dbManager.getCon().prepareStatement(sql));
            dbManager.getPstate().setString(1, inputID);

            dbManager.setRs(dbManager.getPstate().executeQuery());

            if (dbManager.getRs().next()) {
                userDTO.setId(dbManager.getRs().getString("user_id"));
                userDTO.setName(dbManager.getRs().getString("user_name"));
            }
        } catch (Exception e) {
            System.out.println("오류");
        }

        return userDTO;
    }
}
