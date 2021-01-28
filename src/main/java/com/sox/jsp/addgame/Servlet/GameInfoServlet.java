package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.GameDAO;
import com.sox.jsp.addgame.DTO.GameDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GameInfoServlet", value = "/GameInfoServlet")
public class GameInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        GameDAO gameDAO = GameDAO.getInstance();

        ArrayList<GameDTO> gameDTOS = new ArrayList<>();

        String id = (String)session.getAttribute("user");
        gameDTOS = gameDAO.selectGame(id);

        request.setAttribute("games", gameDTOS);
        request.getRequestDispatcher("/game_code_info.jsp").forward(request, response);
    }
}
