package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.GameDAO;
import com.sox.jsp.addgame.DAO.QuestionDAO;
import com.sox.jsp.addgame.DTO.QuestionDTO;
import com.sox.jsp.addgame.GameManager;
import com.sox.jsp.addgame.QuestionMaker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameManager gameManager = GameManager.getInstance();
        QuestionMaker questionMaker = QuestionMaker.getInstance();
        GameDAO gameDAO = GameDAO.getInstance();
        QuestionDAO questionDAO = QuestionDAO.getInstance();

        gameManager.startGame();

        String id = (String)session.getAttribute("user");
        String code = gameManager.makeCode(id);

        /* DB - game, question 저장 */
        gameDAO.insertGame(id, code);
        questionDAO.insertQuestion(code);

        session.setAttribute("game_code", code);

        request.setAttribute("questions", questionMaker.getQuestions());
        request.getRequestDispatcher("/game.jsp").forward(request, response);

        questionMaker.getQuestions().clear();
    }
}
