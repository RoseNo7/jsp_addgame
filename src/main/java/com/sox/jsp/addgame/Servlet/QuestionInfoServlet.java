package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.AnswerDAO;
import com.sox.jsp.addgame.DAO.GameDAO;
import com.sox.jsp.addgame.DAO.QuestionDAO;
import com.sox.jsp.addgame.DTO.AnswerDTO;
import com.sox.jsp.addgame.DTO.QuestionDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "QuestionInfoServlet", value = "/QuestionInfoServlet")
public class QuestionInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("game_code");

        QuestionDAO questionDAO = QuestionDAO.getInstance();
        ArrayList<QuestionDTO> questionDTOS = new ArrayList<>();

        AnswerDAO answerDAO = AnswerDAO.getInstance();
        AnswerDTO answerDTO = new AnswerDTO();

        /* DB - question, answer 가져옴 */
        questionDTOS = questionDAO.selectQuestion(code);
        answerDTO = answerDAO.selectAnswer(code);

        /* inputAnswer를 JSON 형태로 */
        JSONObject jsonObject = new JSONObject(answerDTO.getInputAnswer());
        JSONArray jsonArray = jsonObject.getJSONArray("answer");

        request.setAttribute("questions", questionDTOS);
        request.setAttribute("input", jsonArray);
        request.setAttribute("score", answerDTO.getScore());
        request.getRequestDispatcher("/game_info.jsp").forward(request, response);

    }
}
